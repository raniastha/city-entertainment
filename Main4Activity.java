package com.astha.mini;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import java.util.Collections;

public class Main4Activity extends AppCompatActivity{

    ArrayList<String> myArrayList=new ArrayList<>();
    ListView myListView;
    DatabaseReference mref;
    public int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setTitle("Organisers List");
        Firebase.setAndroidContext(this);

        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArrayList){

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            if (position % 2 == 1) {
                view.setBackgroundColor(Color.LTGRAY);
            } else {
                view.setBackgroundColor(Color.WHITE);
            }

            return view;
        }};

        myListView = (ListView) findViewById(R.id.ListView);
        myListView.setAdapter(myArrayAdapter);
        mref = FirebaseDatabase.getInstance().getReference("list");
        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                myArrayList.add(value);
                myArrayAdapter.notifyDataSetChanged();
                Collections.sort(myArrayList);
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
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                        intent.putExtra("EventName", myListView.getItemAtPosition(position).toString());
                        startActivity(intent);
                    }

                });
    }



}
