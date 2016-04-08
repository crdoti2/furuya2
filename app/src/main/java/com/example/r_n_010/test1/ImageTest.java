package com.example.r_n_010.test1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by R-N-010 on 2016/04/06.
 */
public class ImageTest extends View {
    private Bitmap image = null;
    private Paint mPaint = new Paint();
    private Matrix matrix = new Matrix();

    public ImageTest(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        image = BitmapFactory.decodeResource(getResources(), R.drawable.icon3);
        matrix.setRotate(90, image.getWidth()/2, image.getHeight()/2);//ここで角度を設定
        image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        invalidate();

        canvas.drawBitmap(image, 200,500, mPaint);
    }
}
