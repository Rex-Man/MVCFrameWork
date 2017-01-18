#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>




extern "C" {
JNIEXPORT jintArray JNICALL
    Java_com_oocl_mob_opencvproject_NDKloader_getGrayImage(JNIEnv *env, jclass type, jintArray pixels_,
                                                           jint w, jint h) {
        jint *pixels = env->GetIntArrayElements(pixels_, NULL);
        if (pixels == NULL) {
            return NULL;
        }
        cv::Mat imgData(h, w, CV_8UC4, pixels);
        uchar *ptr = imgData.ptr(0);
        for (int i = 0; i < w * h; i++) {
            int grayScale = (int) (ptr[4 * i + 2] * 0.299 + ptr[4 * i + 1] * 0.587
                                   + ptr[4 * i + 0] * 0.114);
            ptr[4 * i + 1] = (uchar) grayScale;
            ptr[4 * i + 2] = (uchar) grayScale;
            ptr[4 * i + 0] = (uchar) grayScale;
        }

        int size = w * h;
        jintArray result = env->NewIntArray(size);
        env->SetIntArrayRegion(result, 0, size, pixels);
        env->ReleaseIntArrayElements(pixels_, pixels, 0);
        return result;
    }
    JNIEXPORT jintArray JNICALL Java_com_oocl_mob_opencvproject_NDKloader_gray
            (JNIEnv *env, jclass obj, jintArray buf, jint w, jint h) {
        jint *cbuf;
        cbuf = env->GetIntArrayElements(buf, JNI_FALSE);
        if (cbuf == NULL) {
            return 0;
        }

        cv::Mat imgData(h, w, CV_8UC4, (unsigned char *) cbuf);

        uchar *ptr = imgData.ptr(0);
        for (int i = 0; i < w * h; i++) {
            //计算公式：Y(亮度) = 0.299*R + 0.587*G + 0.114*B
            //对于一个int四字节，其彩色值存储方式为：BGRA
            int grayScale = (int) (ptr[4 * i + 2] * 0.299 + ptr[4 * i + 1] * 0.587 +
                                   ptr[4 * i + 0] * 0.114);
            ptr[4 * i + 1] = grayScale;
            ptr[4 * i + 2] = grayScale;
            ptr[4 * i + 0] = grayScale;
        }

        int size = w * h;
        jintArray result = env->NewIntArray(size);
        env->SetIntArrayRegion(result, 0, size, cbuf);
        env->ReleaseIntArrayElements(buf, cbuf, 0);
        return result;
    }

    JNIEXPORT jstring JNICALL
    Java_com_oocl_mob_opencvproject_NDKloader_stringFromJNI(JNIEnv *env, jobject instance) {

        // TODO
        std::string hello = "Hello from C++";
        return env->NewStringUTF(hello.c_str());

    }
}



