package com.oocl.mob.opencvproject;

/**
 * Created by manre on 1/3/17.
 */

public class NDKloader {
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("opencv_java3");
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public static native String stringFromJNI();


    public static native int[] getGrayImage(int[] pixels,int w,int  h);

    public static native int[] gray(int[] buf, int w, int h);
}
