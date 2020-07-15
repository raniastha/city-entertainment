package com.astha.mini;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent i=new Intent(this,MainActivity.class);
        Thread mysplash=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(5000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        mysplash.start();
    }
}
