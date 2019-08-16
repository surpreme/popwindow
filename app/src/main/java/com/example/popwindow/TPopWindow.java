package com.example.popwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

 class TPopWindow {
    private static TPopWindow mInstance;
    private int popDialoglayoutId = R.layout.dailogpopwindow,popViewBottomlayoutId=R.layout.view_bottom_popwindow;
    private PopupWindow popupWindow;

     static TPopWindow getmInstance() {
        if (mInstance == null) {
            synchronized (TPopWindow.class) {
                if (mInstance == null) {
                    mInstance = new TPopWindow();
                }
            }
        }
        return mInstance;
    }

     TPopWindow() {
    }

     /**
      * 
      * @param context
      * @param fatherLayoutId
      * @param backAlpha
      * @param txt
      * @param okBtnClick
      * @param noBtnClick
      */
     void showCenterPopupWindow(final Context context, int fatherLayoutId, float backAlpha, String txt, View.OnClickListener okBtnClick, View.OnClickListener noBtnClick) {
        setBackGroundAlpha(backAlpha, context);
        View view = LayoutInflater.from(context).inflate(popDialoglayoutId, null);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);
        TextView topTxt = view.findViewById(R.id.textView);
        Button okBtn = view.findViewById(R.id.button);
        Button noBtn = view.findViewById(R.id.button2);
        topTxt.setText(txt);
        okBtn.setOnClickListener(okBtnClick);
        noBtn.setOnClickListener(noBtnClick);
        View rootView = LayoutInflater.from(context).inflate(fatherLayoutId, null);
        popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackGroundAlpha(1.0f, context);

            }
        });


    }

     /**
      *
      * @param context
      * @param backAlpha
      * @param mView
      * @param x
      * @param y
      * @param OneLaoyoutClick
      * @param TwoLayoutClick
      * @param ThreeLayoutClick
      * @param oneBmp
      * @param twoBmp
      * @param threeBmp
      * @param oneString
      * @param twoString
      * @param threeString
      */
     void showViewPopupWindow(final Context context, float backAlpha, View mView,int x,int y, View.OnClickListener OneLaoyoutClick, View.OnClickListener TwoLayoutClick, View.OnClickListener ThreeLayoutClick, Bitmap oneBmp,Bitmap twoBmp,Bitmap threeBmp,String oneString,String twoString,String threeString) {
         setBackGroundAlpha(backAlpha, context);
         View ContextLayoutView = LayoutInflater.from(context).inflate(popViewBottomlayoutId, null);
         popupWindow = new PopupWindow(ContextLayoutView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
         popupWindow.setContentView(ContextLayoutView);
         LinearLayout oneLayout=ContextLayoutView.findViewById(R.id.one_layout_id);
         LinearLayout twoLayout=ContextLayoutView.findViewById(R.id.two_layout_id);
         LinearLayout threeLayout=ContextLayoutView.findViewById(R.id.three_layout_id);
         TextView oneTxt=ContextLayoutView.findViewById(R.id.one_txt_id);
         TextView twoTxt=ContextLayoutView.findViewById(R.id.two_txt_id);
         TextView threeTxt=ContextLayoutView.findViewById(R.id.three_txt_id);
         ImageView oneImg=ContextLayoutView.findViewById(R.id.one_img_id);
         ImageView twoImg=ContextLayoutView.findViewById(R.id.two_img_id);
         ImageView threeImg=ContextLayoutView.findViewById(R.id.three_img_id);
         oneLayout.setOnClickListener(OneLaoyoutClick);
         twoLayout.setOnClickListener(TwoLayoutClick);
         threeLayout.setOnClickListener(ThreeLayoutClick);
         oneTxt.setText(oneString);
         twoTxt.setText(twoString);
         threeTxt.setText(threeString);
         oneImg.setImageBitmap(oneBmp);
         twoImg.setImageBitmap(twoBmp);
         threeImg.setImageBitmap(threeBmp);
         popupWindow.showAsDropDown ( mView,x,y );
         popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
             @Override
             public void onDismiss() {
                 setBackGroundAlpha(1.0f, context);

             }
         });

     }
         void dismissPopWindow(){
        if (popupWindow!=null)popupWindow.dismiss();
}

    void setBackGroundAlpha(float alpha, Context context) {

        WindowManager.LayoutParams layoutParams = ((Activity) context).getWindow().getAttributes();
        layoutParams.alpha = alpha;
        ((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ((Activity) context).getWindow().setAttributes(layoutParams);
    }




}
