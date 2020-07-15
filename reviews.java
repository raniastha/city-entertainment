package com.astha.mini;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reviews extends AppCompatActivity {
    DatabaseReference db=FirebaseDatabase.getInstance().getReference("reviews");
    EditText tv1,tv2,tv3,tv4,tv5;
    String s1,s2,s3,s4,s5;
    Button b,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Your Feedback");
        setContentView(R.layout.activity_reviews);
        tv1=findViewById(R.id.textname);
        tv2=findViewById(R.id.textdesc);
        tv3=findViewById(R.id.textplace);
        tv4=findViewById(R.id.yesorno);
        tv5=findViewById(R.id.rate);
        b=findViewById(R.id.sub);

        b5 = (Button) findViewById(R.id.sendimg);

        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoinstagram();
            }

        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=tv1.getText().toString();
                s2=tv2.getText().toString();
                s3=tv3.getText().toString();
                s4=tv4.getText().toString();
                s5=tv5.getText().toString();
                String a=System.currentTimeMillis()+"";
                db.child(a).child("Name").setValue(s1);
                db.child(a).child("Comment").setValue(s2);
                db.child(a).child("Place").setValue(s3);
                db.child(a).child("YesorNo").setValue(s4);
                db.child(a).child("Rate").setValue(s5);
                Toast.makeText(reviews.this, "Submitted. Thanks for your feedback!!", Toast.LENGTH_SHORT).show();

                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv4.setText("");
                tv5.setText("");

            }
        });

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