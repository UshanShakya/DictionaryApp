package com.e.dictionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button btnAddCountry, btnShowCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAddCountry = findViewById(R.id.btnAddCountry);
        btnShowCountry = findViewById(R.id.btnShowCountry);

        btnAddCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AddWordActivity.class);
                intent.putExtra("message", "Showing Add Country Page.");
                startActivity(intent);
            }
        });
        btnShowCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, CapitalActivity.class);
                intent.putExtra("message", "Showing Show Country Page.");

                startActivity(intent);
            }
        });
    }
}
