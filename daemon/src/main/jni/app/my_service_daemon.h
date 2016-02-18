/* 头文件begin */
#include <jni.h>
#include <stdio.h>
#include <string.h>
#include <android/log.h>
#include <unistd.h>
#include "log.h"
#include "service_daemon.h"

/* 头文件end */

/* 宏定义begin */
//清0宏
#define MEM_ZERO(pDest, destSize) memset(pDest, 0, destSize)

//LOG宏定义
#define LOG_INFO(tag, msg) __android_log_write(ANDROID_LOG_INFO, tag, msg)
#define LOG_DEBUG(tag, msg) __android_log_write(ANDROID_LOG_DEBUG, tag, msg)
#define LOG_WARN(tag, msg) __android_log_write(ANDROID_LOG_WARN, tag, msg)
#define LOG_ERROR(tag, msg) __android_log_write(ANDROID_LOG_ERROR, tag, msg)

//#define LOG_I(...)	__android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__)
//#define LOG_D(...)	__android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
//#define LOG_W(...)	__android_log_print(ANDROID_LOG_WARN, TAG, __VA_ARGS__)
//#define	LOG_E(...)	__android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__)
//
//#define LOGI(tag, ...)	__android_log_print(ANDROID_LOG_INFO, tag, __VA_ARGS__)
//#define LOGD(tag, ...)	__android_log_print(ANDROID_LOG_DEBUG, tag, __VA_ARGS__)
//#define LOGW(tag, ...)	__android_log_print(ANDROID_LOG_WARN, tag, __VA_ARGS__)
//#define	LOGE(tag, ...)	__android_log_print(ANDROID_LOG_ERROR, tag, __VA_ARGS__)
/* 宏定义end */

#ifndef _Included_main_activity_UninstalledMoniterActivity
#define _Included_main_activity_UninstalledMoniterActivity
#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     main_activity_UninstalledMoniterActivity
 * Method:    init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_simba_demo_servicedaemon_ServiceDaemon_init(JNIEnv *, jobject, jstring, jstring);

#ifdef __cplusplus
}
#endif
#endif