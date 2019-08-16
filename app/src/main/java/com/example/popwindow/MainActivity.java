package com.example.popwindow;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View.OnClickListener one=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        };
        final View.OnClickListener two=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TPopWindow.getmInstance().dismissPopWindow();

            }
        };
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TPopWindow.getmInstance().showCenterPopupWindow(
                        MainActivity.this,
                        R.layout.activity_main,
                        0.01f,
                        "退出？",
                        one,
                        two);
            }
        });
        final View.OnClickListener first=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        };
        final View.OnClickListener second=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TPopWindow.getmInstance().dismissPopWindow();

            }
        };
        final View.OnClickListener thrid=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        };

        View view=findViewById(R.id.imageView2);
        Resources resources=getResources();
        final Bitmap bitmap= BitmapFactory.decodeResource(resources,R.drawable.timg);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TPopWindow.getmInstance().showViewPopupWindow(MainActivity.this,
                        0.5f,
                        view,
                        0,0,
                        first,second,thrid,
                        bitmap,bitmap,bitmap,
                        "扫一扫",
                        "添加好友",
                        "设置"
                        );
            }
        });
    }
}
