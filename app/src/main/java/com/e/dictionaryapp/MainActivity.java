package com.e.dictionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {



//        public static final String countries[]={
//                "Nepal","Kathmandu",
//                "India","New Delhi",
//                "Bhutan","Dhaka",
//                "USA","Washington D.C.",
//                "UK","London",
//                "Canada","Ottawa"
//
//        };


        private Map<String,String> dictionary;
        public void readfromfile(){
            try {
                FileInputStream fos = openFileInput("country.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fos);
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line= "";

                while ((line=br.readLine()) != null){
                    String[] parts = line.split("->");
                    dictionary.put(parts[0],parts[1]);

                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstCountries = findViewById(R.id.lstCountries);



        dictionary = new HashMap<>();

        readfromfile();


        ArrayAdapter myAdapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_checked,new ArrayList<String>(dictionary.keySet())
        );

        lstCountries.setAdapter(myAdapter);

        lstCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country= parent.getItemAtPosition(position).toString();
                String capital = dictionary.get(country);

                Intent intent = new Intent(MainActivity.this,CapitalActivity.class);
                intent.putExtra("Capital",capital);
                startActivity(intent);


            }
        });

        Bundle bundle= getIntent().getExtras();
        if (bundle!=null){
            String back = bundle.getString("back");
            Toast.makeText(MainActivity.this,back,Toast.LENGTH_LONG).show();




        }
        else
        {
            Toast.makeText(MainActivity.this,"No capital!",Toast.LENGTH_LONG).show();
        }

    }
}