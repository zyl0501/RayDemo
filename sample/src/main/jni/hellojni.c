#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_ray_demo_sample_jni_HelloJni_stringFromJNI(JNIEnv *env, jobject instance) {

    jstring returnValue = "aaaa";
    return (*env)->NewStringUTF(env, returnValue);
}