package com.astha.mini;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity{

    ArrayList<String> myArrayList=new ArrayList<>();
    ListView myListView;
    DatabaseReference mref;
    public Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        start = (Button) findViewById(R.id.button4);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMain();
            }
        });
        Firebase.setAndroidContext(this);

        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArrayList)
        {

            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if (position == 6) {
                    view.setBackgroundColor(Color.YELLOW);
                }
                else if(position==8)
                {
                    view.setBackgroundColor(Color.RED);
                }
                else if(position == 11) {
                    view.setBackgroundColor(Color.GREEN);
                }
                else if(position == 0) {
                    view.setBackgroundColor(Color.CYAN);
                }
                else if(position == 1) {
                    view.setBackgroundColor(Color.BLUE);
                }
                else if(position > 11) {
                    view.setBackgroundColor(Color.WHITE);
                }
                else
                {
                    view.setBackgroundColor(Color.TRANSPARENT);
                }
                return view;
            }};

        myListView = (ListView) findViewById(R.id.ListView);
        myListView.setAdapter(myArrayAdapter);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if(bundle.getString("EventName").equals("Fresher's by Astha"))
             {
                 setTitle("Fresher's by Astha");
                mref = FirebaseDatabase.getInstance().getReference("ToShow/user1");

                mref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String value = dataSnapshot.getValue(String.class);
                        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                                if(position==9)
                                {
                                    Intent callintent = new Intent(Intent.ACTION_DIAL);
                                    callintent.setData(Uri.parse("tel:8884974901"));
                                            startActivity(callintent);
                                }
                                if(position==10)
                                {
                                    Intent mailintent=new Intent(Intent.ACTION_SEND);
                                    String[] recipients={"rani.astharani@gmail.com"};
                                    mailintent.putExtra(Intent.EXTRA_EMAIL, recipients);
                                    mailintent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
                                    mailintent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
                                    mailintent.putExtra(Intent.EXTRA_CC,"raniastha20@gmail.com");
                                    mailintent.setType("text/html");
                                    mailintent.setPackage("com.google.android.gm");
                                    startActivity(Intent.createChooser(mailintent, "Send mail"));
                                }

                                if(position==5)
                                {
                                    Intent mapintent=new Intent(android.content.Intent.ACTION_VIEW);
                                    String[] address={"sit,tumkur"};
                                    mapintent.setData(Uri.parse("geo:13.3269, 77.1261"));
                                    startActivity(mapintent);
                                }
                            }
                        });
                        myArrayList.add(value);
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }

            /////
            if(bundle.getString("EventName").equals("Marathon by Chinmay"))
            {

                setTitle("Marathon by Chinmay");
                mref = FirebaseDatabase.getInstance().getReference("ToShow/user2");

                mref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String value = dataSnapshot.getValue(String.class);
                        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                                if(position==9)
                                {
                                    Intent callintent = new Intent(Intent.ACTION_DIAL);
                                    callintent.setData(Uri.parse("tel:8867823491"));
                                    startActivity(callintent);
                                }
                                if(position==10)
                                {
                                    Intent mailintent=new Intent(Intent.ACTION_SEND);
                                    String[] recipients={"rangadalechinmay@gmail.com"};
                                    mailintent.putExtra(Intent.EXTRA_EMAIL, recipients);
                                    mailintent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
                                    mailintent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
                                    mailintent.putExtra(Intent.EXTRA_CC,"raniastha20@gmail.com");
                                    mailintent.setType("text/html");
                                    mailintent.setPackage("com.google.android.gm");
                                    startActivity(Intent.createChooser(mailintent, "Send mail"));
                                }

                                if(position==5)
                                {
                                    Intent mapintent=new Intent(android.content.Intent.ACTION_VIEW);
                                    String[] address={"siddaganga mutt,tumkur"};
                                    mapintent.setData(Uri.parse("geo:13.3208, 77.1488"));
                                    startActivity(mapintent);
                                }
                            }
                        });
                        myArrayList.add(value);
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }

            ////////


            /////
            if(bundle.getString("EventName").equals("Food Mela by Ritu"))
            {
                setTitle("Food Mela by Ritu");
                mref = FirebaseDatabase.getInstance().getReference("ToShow/user3");

                mref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String value = dataSnapshot.getValue(String.class);
                        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                                if(position==9)
                                {
                                    Intent callintent = new Intent(Intent.ACTION_DIAL);
                                    callintent.setData(Uri.parse("tel:9986554440"));
                                    startActivity(callintent);
                                }
                                if(position==10)
                                {
                                    Intent mailintent=new Intent(Intent.ACTION_SEND);
                                    String[] recipients={"rituagrawal@gmail.com"};
                                    mailintent.putExtra(Intent.EXTRA_EMAIL, recipients);
                                    mailintent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
                                    mailintent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
                                    mailintent.putExtra(Intent.EXTRA_CC,"raniastha20@gmail.com");
                                    mailintent.setType("text/html");
                                    mailintent.setPackage("com.google.android.gm");
                                    startActivity(Intent.createChooser(mailintent, "Send mail"));
                                }

                                if(position==5)
                                {
                                    Intent mapintent=new Intent(android.content.Intent.ACTION_VIEW);
                                    String[] address={"ammanikere,tumkur"};
                                    mapintent.setData(Uri.parse("geo:13.1381,76.8591"));
                                    startActivity(mapintent);
                                }
                            }
                        });
                        myArrayList.add(value);
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }

            ////////

            /////
            if(bundle.getString("EventName").equals("Treasure hunt by Deekshitha"))
            {

                setTitle("Treasure hunt by Deekshitha");
                mref = FirebaseDatabase.getInstance().getReference("ToShow/user4");

                mref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String value = dataSnapshot.getValue(String.class);
                        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                                if(position==9)
                                {
                                    Intent callintent = new Intent(Intent.ACTION_DIAL);
                                    callintent.setData(Uri.parse("tel:7259844554"));
                                    startActivity(callintent);
                                }
                                if(position==10)
                                {
                                    Intent mailintent=new Intent(Intent.ACTION_SEND);
                                    String[] recipients={"deekshitha@gmail.com"};
                                    mailintent.putExtra(Intent.EXTRA_EMAIL, recipients);
                                    mailintent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
                                    mailintent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
                                    mailintent.putExtra(Intent.EXTRA_CC,"raniastha20@gmail.com");
                                    mailintent.setType("text/html");
                                    mailintent.setPackage("com.google.android.gm");
                                    startActivity(Intent.createChooser(mailintent, "Send mail"));
                                }

                                if(position==5)
                                {
                                    Intent mapintent=new Intent(android.content.Intent.ACTION_VIEW);
                                    String[] address={"ammanikere,tumkur"};
                                    mapintent.setData(Uri.parse("geo:13.1381,76.8591"));
                                    startActivity(mapintent);
                                }
                            }
                        });
                        myArrayList.add(value);
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        myArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
            ////////
        }
    }

    public void openMain() {
        Intent intent = new Intent(this, reviews.class);
        startActivity(intent);
    }

}
