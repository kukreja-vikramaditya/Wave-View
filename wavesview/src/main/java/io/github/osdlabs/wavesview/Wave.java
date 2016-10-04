package io.github.osdlabs.wavesview;

import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;

/**
 * Created by vikramaditya on 4/10/16.
 */
class Wave {

    //equation is of the form a sin(kx + wt)

    private float a;
    private float k;
    private float w;

    @FloatRange(from = 0.0f, to = 1.0f)
    private float waveXAxisXOffset;
    @FloatRange(from = 0.0f, to = 1.0f)
    private float waveXAxisYOffset;

    private float waveCurrentProgress;
    private float waveMaxProgress;

    @ColorInt
    private int waveColor;
    @DrawableRes
    private int waveTipDrawable;

    boolean animate;

    public boolean isAnimate() {
        return animate;
    }

    public void setAnimate(boolean animate) {
        this.animate = animate;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getK() {
        return k;
    }

    public void setK(float k) {
        this.k = k;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getWaveXAxisXOffset() {
        return waveXAxisXOffset;
    }

    public void setWaveXAxisXOffset(float waveXAxisXOffset) {
        this.waveXAxisXOffset = waveXAxisXOffset;
    }

    public float getWaveXAxisYOffset() {
        return waveXAxisYOffset;
    }

    public void setWaveXAxisYOffset(float waveXAxisYOffset) {
        this.waveXAxisYOffset = waveXAxisYOffset;
    }

    public float getWaveCurrentProgress() {
        return waveCurrentProgress;
    }

    public void setWaveCurrentProgress(float waveCurrentProgress) {
        this.waveCurrentProgress = waveCurrentProgress;
    }

    public float getWaveMaxProgress() {
        return waveMaxProgress;
    }

    public void setWaveMaxProgress(float waveMaxProgress) {
        this.waveMaxProgress = waveMaxProgress;
    }

    public int getWaveColor() {
        return waveColor;
    }

    public void setWaveColor(int waveColor) {
        this.waveColor = waveColor;
    }

    public int getWaveTipDrawable() {
        return waveTipDrawable;
    }

    public void setWaveTipDrawable(int waveTipDrawable) {
        this.waveTipDrawable = waveTipDrawable;
    }
}
