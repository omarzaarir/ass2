package com.example.ass_tow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.*;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Home extends AppCompatActivity {
    RequestQueue requestQueue;
    ListView listView;

    Mycustomadapter myCustomAdabter;
    ArrayList<pro> listItems = new ArrayList<pro>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.requestQueue = Volley.newRequestQueue(this);

         listView = findViewById(R.id.listview);



//        String url = "https://api.github.com/repos/octocat/Hello-World";
        String url="https://api.github.com/search/repositories?q=android";
        Gson gson=new Gson();

        Request<JSONObject> stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=(JSONArray)response.get("items");

                    for (int i=0;i<=jsonArray.length()-10;i++){
                        listItems.add(new pro(jsonArray.getJSONObject(i).getJSONObject("owner").getString("login"),
                                jsonArray.getJSONObject(i).getString("full_name").toString(),
                                jsonArray.getJSONObject(0).getString("description").toString(),
                                "no",
                                "no",
                                "no",
                                "no"));
                    }
                    listView.setAdapter(myCustomAdabter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Toast.makeText(Home.this, "get data from api is succes ", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                final String statusCode = String.valueOf(error.networkResponse.statusCode);
                Toast.makeText(Home.this, statusCode, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);



//        listItems.add(new pro("ثخصثصخثص", "ثخصخثصخثصخص", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "ثخصخثصخثصخص", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "hghghg", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "ثخصخثصخثصخص", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "hghghgrt", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "eweewe", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "ثخصخثصخثصخص", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "ثخصخثصخثصخص", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "ثخصخثصخثصخص", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "bvbcvc", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "ثخصخثصخثصخص", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));
//        listItems.add(new pro("ثخصثصخثص", "ytttrrقثثقث", "ثصخثصثص", "ثؤوةؤصث ء ةؤء", "ثصوؤةصةؤثص", "ةؤءرةؤءةرثصثةؤ", "ؤةءؤءؤةء"));


         myCustomAdabter = new Mycustomadapter(listItems);

//        listView.setAdapter(myCustomAdabter);

//        getNews(listView);

//        getArray();
        listView.setAdapter(myCustomAdabter);

    }

     void setadapter(){
        this.listView.setAdapter(this.myCustomAdabter);
    }
    void getNews(View view) {

        String URL = "https://jsonplaceholder.typicode.com/users";


//        HttpResponse<String> response = Unirest.get("https://api.collectapi.com/pray/all?data.city=istanbul")
//                .header("content-type", "application/json")
//                .header("authorization", "apikey your_token")
//                .asString();
        Request<JSONObject> jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Log.d("VOLLY","success");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                    Log.d("VOLLY",error.toString()+"");

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

    void getArray() {

//        String url = "https://api.github.com/repos/octocat/Hello-World";
 String url="https://api.github.com/search/repositories?q=android";
Gson gson=new Gson();

        Request<JSONObject> stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=(JSONArray)response.get("items");

                    for (int i=0;i<jsonArray.length();i++){
                        listItems.add(new pro(jsonArray.getJSONObject(i).getJSONObject("owner").getString("login"),
                                 jsonArray.getJSONObject(i).getString("full_name").toString(),
                                jsonArray.getJSONObject(0).getString("description").toString(),
                                "ثؤوةؤصث ء ةؤء",
                                "ثصوؤةصةؤثص",
                                "ةؤءرةؤءةرثصثةؤ",
                                "ؤةءؤءؤةء"));
                    }
//                    Log.d("VOLLY",jsonArray.getJSONObject(0).getString("full_name").toString());
//                    Log.d("VOLLY",jsonArray.getJSONObject(0).getJSONObject("owner").getString("login").toString());
//                    Log.d("VOLLY",jsonArray.getJSONObject(0).getString("description").toString());
//
//
//                    Log.d("VOLLY",jsonArray.getJSONObject(1).getString("full_name").toString());
//                    Log.d("VOLLY",jsonArray.getJSONObject(1).getJSONObject("owner").getString("login").toString());
//                    Log.d("VOLLY",jsonArray.getJSONObject(1).getString("description").toString());

                    Log.d("VOLLY",jsonArray.getJSONObject(jsonArray.length()-10).getString("full_name").toString());
                    Log.d("VOLLY",jsonArray.getJSONObject(2).getJSONObject("owner").getString("login").toString());
                    Log.d("VOLLY",jsonArray.getJSONObject(2).getString("description").toString());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Toast.makeText(Home.this, "get data from api is succes ", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                final String statusCode = String.valueOf(error.networkResponse.statusCode);
                Toast.makeText(Home.this, statusCode, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);


    }

    class Mycustomadapter extends BaseAdapter {
        Mycustomadapter(ArrayList listItems) {
            this.listItems = listItems;
        }

        ArrayList<pro> listItems = new ArrayList<pro>();

        @Override
        public int getCount() {
            return listItems.size();
        }

        @Override
        public Object getItem(int position) {
            return listItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.one_cell_in_listview, null);
            TextView title = view1.findViewById(R.id.cellfull_name);
            title.setText(listItems.get(position).full_name);
            TextView desc=view1.findViewById(R.id.celldescription);
            desc.setText(listItems.get(position).description);
            TextView owner=findViewById(R.id.cellowner);
            owner.setText(listItems.get(position).owner);
            return view1;
        }
    }


}
