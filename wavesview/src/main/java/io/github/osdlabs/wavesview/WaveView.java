package io.github.osdlabs.wavesview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikramaditya on 4/10/16.
 */

public class WaveView extends View {


    private final static int DEFAULT_STROKE_WIDTH = 4;
    private final static float DEFAULT_DX = 5f;
    private Paint mPaint;
    private int[] mColors;
    private float dX = DEFAULT_DX;
    List<Wave> waves = new ArrayList<>();
    private float t = 0f;

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (waves.size() != 0) {
            for (Wave wave : waves) {
                if (wave.isAnimate()) {
                    drawSine(canvas, wave, t);
                    t += 0.1f;
                    invalidate();
                } else
                    drawSine(canvas, wave, 0);
            }
        }

    }

    public void drawSine(Canvas canvas, Wave wave, float t) {
        float x;
        for (x = getPaddingLeft() + wave.getWaveXAxisXOffset() * (getWidth() - getPaddingLeft() - getPaddingRight());
             x < getPaddingLeft() + (getWidth() - getPaddingRight() - getPaddingLeft()) * wave.getWaveCurrentProgress() / wave.getWaveMaxProgress();
                ) {

            mPaint.setColor(wave.getWaveColor());
            canvas.drawLine(
                    x, getPaddingTop() + (float) (wave.getWaveXAxisYOffset() * (getHeight() - getPaddingTop() - getPaddingBottom()) - wave.getA() * Math.sin(wave.getK() * x + wave.getW() * t)),
                    x + dX, getPaddingTop() + (float) (wave.getWaveXAxisYOffset() * (getHeight() - getPaddingTop() - getPaddingBottom()) - wave.getA() * Math.sin(wave.getK() * (x + dX) + wave.getW() * t)),
                    mPaint);
            x += dX;
        }


        float y = (float) (wave.getA() * Math.sin(wave.getK() * x + wave.getW() * t));
        float diagonal = 40;


        Rect src = new Rect(
                (int) (x - diagonal * Math.sqrt(1 / 2)),
                (int) (y + diagonal * Math.sqrt(1 / 2)),
                (int) (x + diagonal * Math.sqrt(1 / 2)),
                (int) (y - diagonal * Math.sqrt(1 / 2)));



    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(DEFAULT_STROKE_WIDTH);

    }


    public void addWave(
            @NonNull float a,
            @NonNull float k,
            @NonNull float w,
            @ColorInt @NonNull int waveColor,
            @DrawableRes int waveTipDrawable,
            @FloatRange(from = 0.00f, to = 1.00f) float xAxisXOffset,
            @FloatRange(from = 0.00f, to = 1.00f) float xAxisYOffset,
            float currentProgress,
            @NonNull float maxProgress,
            @NonNull boolean animate
    ) {


        if (a < 0f)
            a = -a;
        if (currentProgress > maxProgress)
            maxProgress = currentProgress;
        if (maxProgress == 0f)
            maxProgress = 100f;


        Wave foo = new Wave();

        foo.setA(a);
        foo.setK(k);
        foo.setW(w);

        foo.setWaveColor(waveColor);
        foo.setWaveTipDrawable(waveTipDrawable);

        foo.setWaveXAxisXOffset(xAxisXOffset);
        foo.setWaveXAxisYOffset(xAxisYOffset);

        foo.setWaveCurrentProgress(currentProgress);
        foo.setWaveMaxProgress(maxProgress);

        foo.setAnimate(animate);

        waves.add(foo);

        invalidate();
    }

}
