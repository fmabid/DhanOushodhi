package com.example.dhanoushodhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.example.dhanoushodhi.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class DiseaseActivity extends AppCompatActivity {

    private static final String TAG = "DiseaseActivity";

    private ArrayList<Integer> imageUrls = new ArrayList<Integer>();
    private ArrayList<String> disNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.bn_disease);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        diseaseListFull();
    }

    private void diseaseListFull() {
        imageUrls.add(R.drawable.leafblast);
        disNames.add("ধানের পাতা ব্লাস্ট");

        imageUrls.add(R.drawable.leaf_scaled);
        disNames.add("লিফ স্কোল্ড");

        imageUrls.add(R.drawable.sheath_blight);
        disNames.add("শেলথ ব্লাইট");

        imageUrls.add(R.drawable.sheath_rot);
        disNames.add("শেলথ রট");

        imageUrls.add(R.drawable.tungro);
        disNames.add("টুংরো রোগ");

        imageUrls.add(R.drawable.ufra);
        disNames.add("উফরা রোগ");

        imageUrls.add(R.drawable.kando_pocha);
        disNames.add("ধানের কাণ্ড পচা রোগ");

        imageUrls.add(R.drawable.bakani);
        disNames.add("বাকানি রোগ");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageUrls, disNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(DiseaseActivity.this, UploadActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DiseaseActivity.this, UploadActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
