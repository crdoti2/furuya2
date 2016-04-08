package com.example.r_n_010.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> arrayButton = new ArrayList<Button>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView sv = (SurfaceView)findViewById( R.id.SV );
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        arrayButton.add(button1);
        arrayButton.add(button2);



        MySurfaceView dd = new MySurfaceView( this, sv ,arrayButton );


        //MySurfaceView surfaceView = new MySurfaceView(this);
        //setContentView(surfaceView);
        //setContentView(new ImageTest(this));

    }
}
