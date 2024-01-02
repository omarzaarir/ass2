package com.example.ass_tow.data;

import java.util.ArrayList;

public class Persons {
   public static ArrayList<Person> personArrayList=new ArrayList<>();

   public boolean add(Person P){
        if (personArrayList.contains(P)){
            return false;
        }else {
            personArrayList.add(P);
            return true;
        }
    }

}
