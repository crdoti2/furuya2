package com.example.r_n_010.test1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by R-N-010 on 2016/04/06.
 */

public class MySurfaceView implements SurfaceHolder.Callback, Runnable, View.OnClickListener {
  private Thread thread;
  private SurfaceHolder holder;
  private Bitmap image = null;
  private Matrix matrix = new Matrix();
  private float r =0;
  private float speed = 0;
  private boolean rotation = false;
  private Button btn1;
  private Button btn2;

  Bitmap rotetaBitmap;

  private int count = 0;

  private float dx = 5, dy = 5;
  private float screenWidth, screenHeight;
  private static final float rectWidth = 40;
  private static final float rectHeight = 40;
  private int ballx=100;
  private int bally=100;

  public MySurfaceView(Context context ,SurfaceView sv ,ArrayList<Button> arrayButton ){
    //super(context);

    holder = sv.getHolder();
    holder.addCallback(this);
    //holder.setFixedSize(getWidth(), getHeight());
    image = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon3);
    btn1 = arrayButton.get(0);
    btn2 = arrayButton.get(1);
    btn1.setOnClickListener(this);
    btn2.setOnClickListener(this);

  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int f, int w, int h) {
    screenWidth = w;
    screenHeight = h;

    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    thread=null;
  }

  @Override
  public void run() {
    while (thread != null) {
      if (ballx-rectWidth < 0 || ballx + rectWidth > screenWidth)
        dx = -dx;
      if (bally-rectHeight < 0 || bally + rectHeight > screenHeight)
        dy = -dy;
      ballx += dx;
      bally += dy;

      doDraw(holder);
    }
  }

  private void doDraw(SurfaceHolder holder) {
    Canvas canvas = holder.lockCanvas();
    if (canvas != null){
      Paint paint = new Paint();
      paint.setColor(Color.GREEN);
      canvas.drawColor(Color.WHITE);
      //canvas.drawCircle(ballx, bally, 20, paint);

      if(r == 360) r = 0;

      matrix.setRotate(r, image.getWidth() / 2, image.getHeight() / 2);//ここで角度を設定


      canvas.drawBitmap(image, matrix, paint);

      paint.setTextSize(200);
      String s = String.valueOf(count);
      //canvas.drawText(s, 100, 1000, paint);

      if(rotation){
        r = r + speed;
        if(speed <= 50){
          //speed++;
          speed = speed + 0.5f;
        }

      }else{
        if(speed >=0){
          r = r + speed;
          speed = speed - 0.5f;
        }
      }



    //count++;
      holder.unlockCanvasAndPost(canvas);
    }
  }

  public boolean onTouchEvent(MotionEvent event){

    rotation = true;
    return true;
  }

  @Override
  public void onClick(View v) {
    if (v == btn1) {
      rotation = true;


    }else if (v == btn2){
      rotation = false;

    }

  }
}
