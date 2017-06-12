package com.az.drawingtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created: Zorin A.
 * Date: 012 12.06.17.
 */

public class Painting extends View {
    int angle;
    Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint dotPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    public Painting(Context context) {
        super(context);
        init(context);
    }

    public Painting(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setAngle(int i) {
        angle = i;
        invalidate();
    }

    void init(Context context) {
        circlePaint.setColor(context.getResources().getColor(android.R.color.holo_purple));
        dotPaint.setColor(context.getResources().getColor(android.R.color.holo_red_light));
       textPaint.setColor(context.getResources().getColor(android.R.color.black));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int radius = (int) (getHeight() * .5F);
        int height = getHeight();
        int width = getWidth();
        int cX = (int) (width * 0.5F);
        int cY = (int) (height * 0.5F);

        canvas.drawCircle(cX, cY, radius, circlePaint);

        double thetaRad = Math.PI * (angle - 90) / 180F;
        int radiusWithOffset = radius - 20;

        double newPx = cX + radiusWithOffset * cos(thetaRad);
        double newPy = cY + radiusWithOffset * sin(thetaRad);

        canvas.drawCircle((int) newPx, (int) newPy, 15, dotPaint);
    }
}
