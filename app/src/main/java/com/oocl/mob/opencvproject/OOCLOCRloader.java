package com.oocl.mob.opencvproject;

/**
 * Created by manre on 1/6/17.
 */

public class OOCLOCRloader {
    static {
        System.loadLibrary("ooclocr-lib");
        System.loadLibrary("opencv_java3");
    }
    public static native String stringFromJNI();
}
