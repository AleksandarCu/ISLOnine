#include <jni.h>

extern "C" JNIEXPORT jint JNICALL
Java_com_islonline_mobile_testapplication_MainActivity_sumJNI(
        JNIEnv* env,
        jobject /* this */, jint num1, jint num2) {

    return num1 + num2;
}