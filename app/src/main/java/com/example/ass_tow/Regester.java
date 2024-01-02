package com.example.ass_tow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ass_tow.data.Person;
import com.example.ass_tow.data.Persons;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Regester extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText email, first_name, user_name, password, last_name;
    Button btnRegester;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);
        sharedPreferences=  PreferenceManager.getDefaultSharedPreferences(this);


        last_name = findViewById(R.id.last_name);

        password = findViewById(R.id.password);

        user_name = findViewById(R.id.user_name);

        first_name = findViewById(R.id.first_name);

        email = findViewById(R.id.email);

        btnRegester = findViewById(R.id.register);



        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnRegester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    onclickRegester();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    void onclickRegester() throws JSONException {
        String last_name = null, password = null, user_name = null, first_name = null, email = null;

        boolean flag = true;
        if (TextUtils.isEmpty(this.last_name.getText()))
            flag = false;
        else {
            last_name = this.last_name.getText().toString();
        }
        if (TextUtils.isEmpty(this.password.getText()))
            flag = false;
        else {
            password = this.password.getText().toString();
        }
        if (TextUtils.isEmpty(this.user_name.getText()))
            flag = false;
        else {
            user_name = this.user_name.getText().toString();
        }
        if (TextUtils.isEmpty(this.first_name.getText()))
            flag = false;
        else {
            first_name = this.first_name.getText().toString();
        }
        if (TextUtils.isEmpty(this.email.getText()))
            flag = false;
        else {
            email = this.email.getText().toString();
        }



        if (flag) {
//    JSONObject jsonObject=new JSONObject();
//    jsonObject.put("first_name",first_name);
//    jsonObject.put("last_name",last_name);
//    jsonObject.put("password",password);
//    jsonObject.put("user_name",user_name);
//    jsonObject.put("email",email);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            Person person = new Person(email, first_name, last_name, user_name, password);
            Persons persons=new Persons();


            Gson gson = new Gson();
            String s = gson.toJson(person);

            String users=sharedPreferences.getString("users","not_exist");

            ArrayList<Person> perso=new ArrayList<>();
            if (!users.equals("not_exist"))
                persons.personArrayList= gson.fromJson(users, perso.getClass());



           if (!persons.add(person)){
               Toast.makeText(this, "this user name is alrady exist", Toast.LENGTH_SHORT).show();
           }else {
               editor.remove("users");
               editor.putString("users",gson.toJson(Persons.personArrayList));
               editor.commit();

           }

            Intent intent = new Intent(this, Profile.class);
           intent.putExtra("myUser",s);
            Bundle bundle = new Bundle();
            bundle.putString("myUser",s);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(this, "all faild is required!", Toast.LENGTH_SHORT).show();
        }


    }
}