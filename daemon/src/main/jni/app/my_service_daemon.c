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
#include "my_service_daemon.h"

#ifdef __cplusplus
extern "C"
{
#endif

#define BUFFER_SIZE 60
#define TAG		"service_daemon"
static jboolean isCopy = JNI_TRUE;

JNIEXPORT void JNICALL Java_com_simba_demo_servicedaemon_ServiceDaemon_init(JNIEnv *env, jobject obj, jstring package_name, jstring service_name){
	jstring tag = (*env)->NewStringUTF(env, TAG);

    LOG_DEBUG((*env)->GetStringUTFChars(env, tag, &isCopy)
            , (*env)->GetStringUTFChars(env, (*env)->NewStringUTF(env, "init observer"), &isCopy));

    // fork子进程，以执行轮询任务
    pid_t pid = fork();
    if (pid < 0)
    {
        LOG_ERROR((*env)->GetStringUTFChars(env, tag, &isCopy)
                , (*env)->GetStringUTFChars(env, (*env)->NewStringUTF(env, "fork failed !!!"), &isCopy));

        exit(1);
    }
    else if (pid == 0)
    {
    	int ppid = getppid();
    	int res = execlp("service_daemon", "-p", package_name, "-n", service_name, "-ppid", ppid,(char *) NULL);
    	if(res == 0){
    	LOG_ERROR((*env)->GetStringUTFChars(env, tag, &isCopy)
                        , (*env)->GetStringUTFChars(env, (*env)->NewStringUTF(env, "start service_daemon success !!!"), &isCopy));
    	}else{
    	LOG_ERROR((*env)->GetStringUTFChars(env, tag, &isCopy)
                                , (*env)->GetStringUTFChars(env, (*env)->NewStringUTF(env, "start service_daemon failed !!!"), &isCopy));
    	}
    }
    else
    {
        // 父进程直接退出，使子进程被init进程领养，以避免子进程僵死，同时返回子进程pid
        return pid;
    }
}

#ifdef __cplusplus
}
#endif