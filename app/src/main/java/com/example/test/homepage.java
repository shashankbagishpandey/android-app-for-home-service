package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class homepage extends AppCompatActivity {

    ImageView imageplum;
    ImageView imagepaint;
    ImageView imageele;
    ImageView imagecarp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);



        // initialize imageView
        // with method findViewById()
        imageplum = findViewById(R.id.img_plum);
        imagecarp =findViewById(R.id.img_carp);
        imagepaint=findViewById(R.id.img_paint);
        imageele=findViewById(R.id.img_ele);

        // Apply OnClickListener  to imageView to
        // switch from one activity to another



        imageplum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(homepage.this, plumber.class);
                startActivity(intent);
            }
        });

        imagecarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(homepage.this, MainActivity.class);
                startActivity(intent);
            }
        });


        imagepaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(homepage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imageele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //Intent class will help to go to next activity using
                 //it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(homepage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}