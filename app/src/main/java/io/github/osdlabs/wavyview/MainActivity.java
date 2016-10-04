package io.github.osdlabs.wavyview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.osdlabs.wavesview.WaveView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WaveView waveView = (WaveView) findViewById(R.id.wavesview);

        waveView.addWave(100,0.01f,0.9f,Color.WHITE,R.drawable.ic_arraow,0,0.5f,60,100,true);
        waveView.addWave(50,0.02f,0.9f,Color.BLACK,R.drawable.ic_arraow,0,0.4f,60,100,true);

        /**
         * addWave - params
         * wave color
         * wave tip icon
         * wave progress
         * wave equation
         *
         */



    }
}
