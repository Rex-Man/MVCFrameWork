package com.oocl.mob.opencvproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.oocl.mob.opencvproject.Butterknife.ButterKnifeMainActivity;
import com.oocl.mob.opencvproject.EventBusStudy.EventBusMainActivity;
import com.oocl.mob.opencvproject.ViewActivity.LoginActivity;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    private static String TAG = "OpenCVLoader";
    private ImageView show_image;
    private Button eventBusBtn;

    @BindView(R2.id.studyButterKnifeButton)
    public Button butterKnifeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(OOCLOCRloader.stringFromJNI());
        initView();

    }
    @OnClick(R2.id.studyButterKnifeButton) void BtnButterKnifeOnClick(View v)
    {
        Intent intent = new Intent(MainActivity.this,ButterKnifeMainActivity.class);
        startActivity(intent);
    }
    @OnClick(R2.id.mvcButton) void BtnMVCOnclick()
    {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    private void initView() {


        show_image = (ImageView) findViewById(R.id.show_image);
        show_image.setImageResource(R.drawable.co2_index_icon);
        eventBusBtn= (Button) findViewById(R.id.eventBus);
        findViewById(R.id.pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //恢复
                backPic();
            }
        });
        findViewById(R.id.gray_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //变灰
                gray();
                //grayPic();
            }
        });
        eventBusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, EventBusMainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void backPic(){
        show_image.setImageResource(R.drawable.co2_index_icon);
    }

    private void grayPic(){
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.co2_index_icon);
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        int[] pixels = new int[w*h];
        bmp.getPixels(pixels, 0, w, 0, 0, w, h);
        //recall JNI
        int[] resultInt = NDKloader.getGrayImage(pixels, w, h);
        Bitmap resultImg = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        resultImg.setPixels(resultInt, 0, w, 0, 0, w, h);
        show_image.setImageBitmap(resultImg);
    }

    private void gray(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.co2_index_icon);
        int w = bitmap.getWidth(), h = bitmap.getHeight();
        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
        int [] resultPixes= NDKloader.gray(pix, w, h);
        Bitmap result = Bitmap.createBitmap(w,h, Bitmap.Config.RGB_565);
        result.setPixels(resultPixes, 0, w, 0, 0,w, h);
        ImageView img=(ImageView)findViewById(R.id.show_image);
        img.setImageBitmap((result));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (OpenCVLoader.initDebug()) {
            Log.i(TAG, "OpenCV initialize success");
        } else {
            Log.i(TAG, "OpenCV initialize failed");
        }
    }

}
