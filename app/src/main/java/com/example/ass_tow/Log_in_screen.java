package com.example.ass_tow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.google.gson.Gson;

import org.json.JSONObject;

public class Log_in_screen extends AppCompatActivity {

    EditText user_name,password;
    Switch remember_me;

    Button logIn,regester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        user_name=findViewById(R.id.log_in_user_name);
        password=findViewById(R.id.log_in_password);
        remember_me=findViewById(R.id.remember_me);

        logIn=findViewById(R.id.log_in_btnlog_in);
        regester=findViewById(R.id.log_in_btnregister);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicklLogIn();
            }
        });
        regester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickRegester();
            }
        });
    }
    void onClicklLogIn(){

        SharedPreferences sharedPreferences=  PreferenceManager.getDefaultSharedPreferences(this);

       String users= sharedPreferences.getString("User#1","not_exist");

        if (!users.equals("not_exist")){
            Gson gson=new Gson();
            JSONObject jsonObject = gson.fromJson(users, JSONObject.class);//...error

//            Log.d("onclicklogin",jsonObject.toString());
            //shuld made users class to store all class in it then convert bt gson then sored it in SP
            //problems:
            //api and show content in View
            //improve the UI
            //completing the log in
        }
        else {

            Intent intent=new Intent(this,Home.class);
            startActivity(intent);
            finish();
        }

    }
    void onclickRegester()  {

        try {
            Intent intent=new Intent(Log_in_screen.this, Regester.class);
            startActivity(intent);
            finish();
//        finish();

        }catch (Exception e){

        }
    }
}