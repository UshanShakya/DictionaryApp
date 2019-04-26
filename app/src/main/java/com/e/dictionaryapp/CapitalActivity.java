package com.e.dictionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CapitalActivity extends AppCompatActivity {

    private TextView tvMeaning;
    private Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);


        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String capital = bundle.getString("Capital");
            tvMeaning=findViewById(R.id.tvMeaning);
            tvMeaning.setText(capital);

        }
        else
        {
            Toast.makeText(CapitalActivity.this,"No capital!",Toast.LENGTH_LONG).show();
        }

        String as = bundle.getString("message");
        Toast.makeText(CapitalActivity.this,as,Toast.LENGTH_LONG).show();


        btnback= findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent = new Intent(CapitalActivity.this,MainActivity.class);
                backintent.putExtra("back","You came back.");
                startActivity(backintent);
            }
        });
    }
}
