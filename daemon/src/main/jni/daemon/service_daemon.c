/*
 * File        : daemon.c
 * Author      : Ray Chio
 * Date        : Apr. 22, 2015
 * Description : This is used as process daemon.
 *
 * Copyright (C) Ray Chio<RayChio66@gmail.com>
 * Thanks for Vincent Chueng
 *
 */

#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <sys/system_properties.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>
#include <sys/inotify.h>
#include <sys/stat.h>

#include "service_daemon.h"

#define LOG_TAG         "service_daemon"
#define	MAXFILE         3
#define SLEEP_INTERVAL  2 * 60
#define BUFFER_SIZE 	60

volatile int sig_running = 1;


/* start daemon service */
static void start_service(char *package_name, char *service_name)
{
	/* get the sdk version */
	int version = get_version();

	pid_t pid;

	if ((pid = fork()) < 0)
	{
		exit(EXIT_SUCCESS);
	}
	else if (pid == 0)
	{
		if (package_name == NULL || service_name == NULL)
		{
			LOGE(LOG_TAG, "package name or service name is null");
			return;
		}

		char *p_name = str_stitching(package_name, "/");
		char *s_name = str_stitching(p_name, service_name);
		LOGD(LOG_TAG, "service: %s", s_name);

		if (version >= 17 || version == 0)
		{
			int ret = execlp("am", "am", "startservice",
						"--user", "0", "-n", s_name, (char *) NULL);
			LOGD(LOG_TAG, "result %d", ret);
		}
		else
		{
			execlp("am", "am", "startservice", "-n", s_name, (char *) NULL);
		}

		LOGD(LOG_TAG , "exit start-service child process");
		exit(EXIT_SUCCESS);
	}
}


int main(int argc, char *argv[])
{
	int i;
	pid_t pid;
	char *package_name = NULL;
	char *service_name = NULL;
	char *daemon_file_dir = NULL;
	int interval = SLEEP_INTERVAL;
	pid_t ppid;

	if (argc < 7)
	{
		LOGE(LOG_TAG, "usage: %s -p package-name -s "
		 "daemon-service-name -t interval-time", argv[0]);
		return;
	}

	for (i = 0; i < argc; i ++)
	{
		if (!strcmp("-p", argv[i]))
		{
			package_name = argv[i + 1];
			LOGD(LOG_TAG, "package name: %s", package_name);
		}

		if (!strcmp("-s", argv[i]))
		{
			service_name = argv[i + 1];
			LOGD(LOG_TAG, "service name: %s", service_name);
		}

		if (!strcmp("-ppid", argv[i]))
		{
			ppid = atoi(argv[i + 1]);
			LOGD(LOG_TAG, "ppid: %d", ppid);
		}
	}

	/* package name and service name should not be null */
	if (package_name == NULL || service_name == NULL)
	{
		LOGE(LOG_TAG, "package name or service name is null");
		return;
	}

	LOGD(LOG_TAG, "service_daemon start running");

	if ((pid = fork()) < 0)
	{
		exit(EXIT_SUCCESS);
	}
	else if (pid == 0)
	{
		/* add signal */
    	// signal(SIGTERM, sigterm_handler);

		/* become session leader */
		setsid();
		/* change work directory */
		chdir("/");

		for (i = 0; i < MAXFILE; i ++)
		{
			close(i);
		}

		/* find pid by name and kill them */
		int pid_list[100];
		int total_num = find_pid_by_name(argv[0], pid_list);
		LOGD(LOG_TAG, "total num %d", total_num);
		for (i = 0; i < total_num; i ++)
		{
			int retval = 0;
			int daemon_pid = pid_list[i];
			if (daemon_pid > 1 && daemon_pid != getpid())
			{
				retval = kill(daemon_pid, SIGTERM);
				if (!retval)
				{
					LOGD(LOG_TAG, "kill daemon process success: %d", daemon_pid);
				}
				else
				{
					LOGD(LOG_TAG, "kill daemon process %d fail: %s", daemon_pid, strerror(errno));
					exit(EXIT_SUCCESS);
				}
			}
		}

		LOGD(LOG_TAG, "child process fork ok, daemon start: %d", getpid());

		char proc_dir[BUFFER_SIZE];
		sprintf(proc_dir, "/proc/%d", ppid);

//		char proc_files_dir[BUFFER_SIZE];
//		char proc_observed_file[BUFFER_SIZE];
//		char proc_lock_file[BUFFER_SIZE];

//		sprintf(proc_files_dir, "/data/data/%s/files", package_name);
//		sprintf(proc_observed_file, "/data/data/%s/files/observedFile", package_name);
//		sprintf(proc_lock_file, "/data/data/%s/files/lockFile", package_name);

		LOGD(LOG_TAG, "observed by child process: %d", getpid());

        // 分配空间，以便读取event
        void *p_buf = malloc(sizeof(struct inotify_event));
        if (p_buf == NULL)
        {
			LOGE(LOG_TAG, "malloc failed !!!");
            exit(1);
        }
        // 分配空间，以便打印mask
        int maskStrLength = 7 + 10 + 1;// mask=0x占7字节，32位整形数最大为10位，转换为字符串占10字节，'\0'占1字节
        char *p_maskStr = malloc(maskStrLength);
        if (p_maskStr == NULL)
        {
            free(p_buf);

            LOGE(LOG_TAG, "malloc failed !!!");
            exit(1);
        }

        // 开始监听
        LOGE(LOG_TAG, "start observe");

        // 初始化
        int fileDescriptor = inotify_init();
        if (fileDescriptor < 0)
        {
            free(p_buf);
            free(p_maskStr);

			LOGE(LOG_TAG, "inotify_init failed !!!");

            exit(1);
        }

        // 添加被监听文件到监听列表
        int watchDescriptor = inotify_add_watch(fileDescriptor, proc_dir, IN_ALL_EVENTS);
        if (watchDescriptor < 0)
        {
            free(p_buf);
            free(p_maskStr);

			LOGE(LOG_TAG, "inotify_add_watch failed !!!");

            exit(1);
        }

        while(1)
        {
            // read会阻塞进程
            size_t readBytes = read(fileDescriptor, p_buf, sizeof(struct inotify_event));

            // 打印mask
            snprintf(p_maskStr, maskStrLength, "mask=0x%x\0", ((struct inotify_event *) p_buf)->mask);
            // LOGD(LOG_TAG, p_maskStr);

            // 若文件被删除，可能是已停止运行
            if (IN_DELETE_SELF == ((struct inotify_event *) p_buf)->mask)
            {
                FILE *p_procDir = fopen(proc_dir, "r");
                // 确认已停止运行
                if (p_procDir == NULL)
                {
                    inotify_rm_watch(fileDescriptor, watchDescriptor);

                    break;
                }
                // 未停止运行，可能用户执行了"清除数据"
                else
                {
                    fclose(p_procDir);

                    // 重新创建被监听文件，并重新监听
                    FILE *p_observedFile = fopen(proc_dir, "w");
                    fclose(p_observedFile);

                    int watchDescriptor = inotify_add_watch(fileDescriptor, proc_dir, IN_ALL_EVENTS);
                    if (watchDescriptor < 0)
                    {
                        free(p_buf);
                        free(p_maskStr);

						LOGE(LOG_TAG, "notify_add_watch failed !!!");

                        exit(1);
                    }
                }
            }
        }

        // 释放资源
        free(p_buf);
        free(p_maskStr);

        // 停止监听
        LOGE(LOG_TAG, "stop observe");

        start_service(package_name, service_name);

        // 执行命令失败log
        LOGE(LOG_TAG, "exec AM command failed !!!");
	}
	else
	{
		/* parent process */
	}
}
