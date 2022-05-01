package com.example.redrockmidtermexam.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.redrockmidtermexam.R;

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
public class CustomerView extends View {
    private Paint sidePaint,srcPaint;
    private float sideWidth = 10;//边框的宽度
    private int sideColor = Color.BLACK;
    private int radius = 130;//六边形的半径
    private int width;
    private int height;
    private PorterDuffXfermode mPorterDuffXfermode;

    public CustomerView(Context context) {
        this(context,null);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        sidePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        sidePaint.setStyle(Paint.Style.STROKE);
        sidePaint.setStrokeWidth(sideWidth);
        sidePaint.setColor(sideColor);
        srcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getMeasuredWidth();//控件宽度
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bgBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas bgCanvas = new Canvas(bgBitmap);
        drawPicture(bgCanvas,srcPaint);
        srcPaint.setXfermode(mPorterDuffXfermode);
        canvas.drawBitmap(bgBitmap,0,0,null);
        srcPaint.setXfermode(null);

        drawPicture(canvas,sidePaint);
    }
    //画六边形
    private void drawPicture(Canvas bgCanvas,Paint paint) {
        float left = (float) ((width - Math.sqrt(3) * radius) / 2.0);
        float top = (float) ((height - 2 * radius) / 2.0);
        Path localPath = new Path();
        localPath.moveTo((float) (left + Math.sqrt(3) * radius /2.0),top);
        localPath.lineTo(left, top + radius / 2);
        localPath.lineTo(left, top + 1.5f * radius);
        localPath.lineTo((float) (left + Math.sqrt(3) * radius / 2.0f), top + 2 * radius);
        localPath.lineTo((float) (left + Math.sqrt(3) * radius), top + 1.5f * radius);
        localPath.lineTo((float) (left + Math.sqrt(3) * radius), top + radius / 2.0f);
        localPath.lineTo((float) (left + Math.sqrt(3) * radius /2.0),top);
        localPath.close();
        bgCanvas.drawPath(localPath, paint);
    }
}


