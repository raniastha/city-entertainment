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

import java.util.regex.Pattern;

public class Main3Activity extends AppCompatActivity {
    DatabaseReference db=FirebaseDatabase.getInstance().getReference("Users");
    EditText tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Submission Form");
        setContentView(R.layout.activity_main3);
        tv1=findViewById(R.id.editText14);
        tv2=findViewById(R.id.editText12);
        tv3=findViewById(R.id.editText13);
        tv4=findViewById(R.id.editText15);
        tv5=findViewById(R.id.editText16);
        tv6=findViewById(R.id.editText17);
        tv7=findViewById(R.id.editText18);
        tv8=findViewById(R.id.editText19);
        b=findViewById(R.id.button3);
        b1 = (Button) findViewById(R.id.img);

        b1.setOnClickListener(new View.OnClickListener() {
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
                s6=tv6.getText().toString();
                s7=tv7.getText().toString();
                s8=tv8.getText().toString();
                String a=System.currentTimeMillis()+"";


                if(isValidPhone(tv2.getText().toString()) && isValidEmail(tv3.getText().toString().trim())){

                    db.child(a).child("Name").setValue(s1);
                    db.child(a).child("mobile").setValue(s2);
                    db.child(a).child("email").setValue(s3);
                    db.child(a).child("EventName").setValue(s4);
                    db.child(a).child("date").setValue(s5);
                    db.child(a).child("time").setValue(s6);
                    db.child(a).child("location").setValue(s7);
                    db.child(a).child("description").setValue(s8);

                    Toast.makeText(Main3Activity.this, "Submitted !!", Toast.LENGTH_SHORT).show();
                    tv1.setText("");
                    tv2.setText("");
                    tv3.setText("");
                    tv4.setText("");
                    tv5.setText("");
                    tv6.setText("");
                    tv7.setText("");
                    tv8.setText("");
                }else {

                    Toast.makeText(getApplicationContext(),"Invalid data",Toast.LENGTH_SHORT).show();
                    tv2.setText("");
                    tv3.setText("");
                }




            }
        });}

        // newRef = db.child("1").push();
        //newRef.setValue("hello");

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
    boolean checkp;
    public boolean isValidPhone(CharSequence phone) {
        if(phone.length() < 10 || phone.length() > 10)
        {
            checkp = false;

        }
        else
        {
            checkp = true;

        }
        return checkp;
    }

    boolean isValidEmail(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}