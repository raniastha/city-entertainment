package com.astha.mini;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Main2Activity extends AppCompatActivity {
    public Button organiser,attender,detail,instag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        organiser = (Button) findViewById(R.id.button2);
        attender = (Button) findViewById(R.id.button1);
        detail = (Button) findViewById(R.id.det);
        instag = (Button) findViewById(R.id.insta);

        organiser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMain2();
            }

        });
        attender.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMain1();
            }

        });
        detail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMain3();
            }

        });
        instag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoinstagram();
            }

        });
        ///

        ///
    }
    public void openMain2(){
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);

    }
    public void openMain1(){
        Intent intent=new Intent(this,Main4Activity.class);
        startActivity(intent);

    }
    public void openMain3(){
        Intent intent=new Intent(this,Details.class);
        startActivity(intent);

    }
    public void gotoinstagram()
    {

        Uri uri = Uri.parse("http://instagram.com/_u/_environ_s_");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/_environ_s_")));
        }

    }
}
