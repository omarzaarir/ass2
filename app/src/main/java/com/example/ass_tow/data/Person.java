package com.example.ass_tow.data;

import androidx.annotation.Nullable;

public class Person {
   public String email,user_name,first_name,last_name,password;


  public Person(String email,String first_name,String last_name,String user_name,String password){
        this.email=email;
        this.first_name=first_name;
        this.last_name=last_name;
        this.password=password;
        this.user_name=user_name;
   }

    @Override
    public boolean equals(@Nullable Object obj) {
       if (obj instanceof Person){
           if (((Person) obj).user_name.equals(this.user_name))
           return true;
       }else
           return false;
        return super.equals(obj);

    }
}
