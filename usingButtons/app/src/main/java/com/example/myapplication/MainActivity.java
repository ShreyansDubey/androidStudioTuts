package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        ImageView imageView = findViewById(R.id.trees);
        String img = String.valueOf(imageView.getTag());
        if (img == "tree1") {
            imageView.setImageResource(R.drawable.tree2);
            imageView.setTag("tree2");
        } else{
            imageView.setImageResource(R.drawable.tree1);
            imageView.setTag("tree1");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
