package com.astha.mini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMain();
            }
        });

    }
    public void openMain(){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);

    }


}
