#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>
//
// Created by REX MAN (EUCD-EUC-ISD-OOCLL/ZHA) on 1/6/17.
//
extern "C" {
    JNIEXPORT jstring JNICALL
    Java_com_oocl_mob_opencvproject_OOCLOCRloader_stringFromJNI(JNIEnv *env, jclass type) {

        std::string hello = "Hello from OCR C++";
        return env->NewStringUTF(hello.c_str());
    }
}