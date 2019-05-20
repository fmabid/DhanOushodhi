package com.example.dhanoushodhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";

    private final static String DISEASE_SELECTED = "diseaseName";

    String disease;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        disease = getIntent().getStringExtra(DISEASE_SELECTED);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(disease);
        setSupportActionBar(toolbar);

        /*Log.d(TAG, "onCreate called.   --> " + disease );*/
    }
}
