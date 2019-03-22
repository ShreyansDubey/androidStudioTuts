package com.example.fadingimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){
        ImageView tj_one = findViewById(R.id.tj_one);
        ImageView tj_two = findViewById(R.id.tj_two);
        tj_one.animate().alpha(0.0f).setDuration(2000);
        tj_two.animate().alpha(1.0f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
