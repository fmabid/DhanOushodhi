package com.example.dhanoushodhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class PestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pest);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.bn_pests);
        setSupportActionBar(toolbar);
    }
}
