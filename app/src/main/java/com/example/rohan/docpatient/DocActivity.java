package com.example.rohan.docpatient;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DocActivity extends AppCompatActivity {
Button bute;
 private  String pname,s="",sp="";
    RadioGroup rGroup;
    TextView nametext,destext,spltext;
    ImageView imgProfile;
    private FirebaseAuth firebaseAuth;
    DatabaseReference dbref,dbpatient;
    RadioButton checkedRadioButton;
    ArrayList<profile> listofdes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
         rGroup = (RadioGroup)findViewById(R.id.radioSex);
        checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());
        listofdes=new ArrayList<profile>();
        Intent intent=getIntent();

        String s1=intent.getStringExtra("nam");
bute=(Button) findViewById(R.id.button);


        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked)
                {
                    Toast.makeText(DocActivity.this, checkedRadioButton.getText(),Toast.LENGTH_SHORT).show();

                    // Changes the textview's text to "Checked: example radiobutton text"
                //    tv.setText("Checked:" + checkedRadioButton.getText());
                }
            }
        });







bute.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        firebaseAuth=FirebaseAuth.getInstance();
        String email=firebaseAuth.getCurrentUser().getEmail();

        int in=email.indexOf('@');
        pname=email.replace(".com","");
//        pname=email.substring(0,in);

       // Toast.makeText(DocActivity.this,pname,Toast.LENGTH_SHORT).show();
        dbpatient=FirebaseDatabase.getInstance().getReference().child("Patient").child(pname);
        
        dbpatient.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               patient value = dataSnapshot.getValue(patient.class);
                //String st=value
               s =sp+"-"+value.getNamePatient()+" ";
                Toast.makeText(DocActivity.this, s,Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        // Intent i=new Intent(DocActivity.this,LoginActivity.class);

   //     startActivity(i);
    s="";
    }
});
        nametext=(TextView) findViewById(R.id.nameq);
        destext=(TextView) findViewById(R.id.description);
        spltext=(TextView) findViewById(R.id.spl);
        imgProfile=(ImageView) findViewById(R.id.profilepicture);
        dbref=FirebaseDatabase.getInstance().getReference().child("Profile").child(s1);

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                profile p=dataSnapshot.getValue(profile.class);

                nametext.setText(p.getName());
                destext.setText(p.getDes());
                spltext.setText(p.getEmail());
                //  Picasso.with(this).load(p.getProfilePic()).into(imgProfile);
                Picasso.get().load(p.getProfilePic()).into(imgProfile);

                sp = p.getName();
                //Toast.makeText(DocActivity.this,p.getEmail(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






    }
}
