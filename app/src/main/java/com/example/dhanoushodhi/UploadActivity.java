package com.example.dhanoushodhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Objects;

public class UploadActivity extends AppCompatActivity {

    Toolbar toolbar;
    View view_disease;
    View view_pest;
    View view_nutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("তালিকা");
        setSupportActionBar(toolbar);

        view_disease = findViewById(R.id.cardview_disease);
        view_pest = findViewById(R.id.cardview_pests);
        view_nutrition = findViewById(R.id.cardview_nutrition_def);

        view_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadActivity.this, DiseaseActivity.class);
                startActivity(intent);
            }
        });

        view_pest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadActivity.this, PestActivity.class);
                startActivity(intent);
            }
        });

        view_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadActivity.this, NutritionActivity.class);
                startActivity(intent);
            }
        });
    }
}
