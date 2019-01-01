package com.example.rohan.docpatient;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<profile> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);




        Intent intent =getIntent();
        final String message=intent.getStringExtra("val");
        Toast.makeText(SelectActivity.this,message,Toast.LENGTH_LONG).show();
        recyclerView=(RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<profile>();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Profile");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren())
                {
                    profile p=dataSnapshot1.getValue(profile.class);
                    if(p.getEmail().equals(message))
                    {
                        list.add(p);
                    }
                    if(message.equals("Others"))
                    {
                        list.add(p);
                    }

                    //
                }
                Log.v("", String.valueOf(list));
                adapter=new MyAdapter(SelectActivity.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(SelectActivity.this,"oops something went wrong",Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.addOnItemTouchListener(new MyAdapter(SelectActivity.this, recyclerView, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(SelectActivity.this,"item "+(position+1),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SelectActivity.this,DocActivity.class);
                intent.putExtra("val",list.get(position).getName());
                intent.putExtra("nam",list.get(position).getNam());
                startActivity(intent);
                // ...
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));




    }
}
