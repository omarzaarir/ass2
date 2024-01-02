package com.example.ass_tow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ass_tow.data.Person;
import com.google.gson.Gson;

public class Profile extends AppCompatActivity {

    ImageView profile_image;
    TextView profile_email,profile_full_name,profile_user_name;
    Button profile_btnLOGOUT;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_email=findViewById(R.id.profile_email);
        profile_image=findViewById(R.id.profile_image);
        profile_full_name=findViewById(R.id.profile_full_name);
        profile_user_name=findViewById(R.id.profile_user_name);
        profile_btnLOGOUT= this.<Button>findViewById(R.id.profile_btnLOGOUT);

        Log.d("VOLLY","oncreat");

//the error is here when fromjson method............................................................
            String myUser= savedInstanceState.getString("myUser","not exist");
            if (!myUser.equals("not exist")){
                Gson gson=new Gson();
              Person person=gson.fromJson(myUser,Person.class);
                Log.d("VOLLY",person.getClass().toString());
                profile_email.setText(person.email);
                profile_full_name.setText(person.first_name+" "+person.last_name);
                profile_user_name.setText(person.user_name);
                Log.d("VOLLY","add values from build");

            }else {
                profile_email.setText("person.email");
                profile_full_name.setText("person.first_nameperson.last_name");
                profile_user_name.setText("person.user_name");
                Log.d("VOLLY","add defoult values");
            }
//..................................................................................................
        Log.d("VOLLY","oncreat+++");
        profile_btnLOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickbtnLOGOUT();
            }
        });

    }

   void onClickbtnLOGOUT(){
       Intent intent=new Intent(this,Log_in_screen.class);
       startActivity(intent);
       finish();
    }


}