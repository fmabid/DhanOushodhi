package com.example.dhanoushodhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class DiseaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.bn_disease);
        setSupportActionBar(toolbar);
    }
}
