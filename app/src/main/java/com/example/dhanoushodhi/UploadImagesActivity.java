package com.example.dhanoushodhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;

public class UploadImagesActivity extends AppCompatActivity {
    private static final String TAG = "UploadImagesActivity";

    private final static String DISEASE_SELECTED = "diseaseName";

    String disease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_images);

        disease = getIntent().getStringExtra(DISEASE_SELECTED);
        // Log.d(TAG, "onCreate called.   --> " + disease );

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(disease);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(UploadImagesActivity.this, DiseaseActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(UploadImagesActivity.this, DiseaseActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
