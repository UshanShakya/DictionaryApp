package com.e.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {

    EditText etCountry, etCapital;
    Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etCapital= findViewById(R.id.etCapital);
        etCountry= findViewById(R.id.etCountry);
        btnSave= findViewById(R.id.btnSave);

        Bundle bundle = getIntent().getExtras();

        String as = bundle.getString("message");
        Toast.makeText(AddWordActivity.this,as,Toast.LENGTH_LONG).show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }
    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("country.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etCountry.getText().toString()+"->"+etCapital.getText().toString());
            Toast.makeText(AddWordActivity.this,"Saved to "+getFilesDir(), Toast.LENGTH_LONG).show();
        }
        catch (IOException e){

            Log.d("Country Capital App", "Error" + e.toString());
            e.printStackTrace();
        }
    }
}
