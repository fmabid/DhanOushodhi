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

public class NutritionActivity extends AppCompatActivity {

    private static final String TAG = "NutritionActivity";

    private ArrayList<Integer> imageUrls = new ArrayList<Integer>();
    private ArrayList<String> deficiencyNames = new ArrayList<>();
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.bn_nutrition_def);
        setSupportActionBar(toolbar);
        category = toolbar.getTitle().toString();
        // Log.d(TAG, "cat.   --> " + category);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nutritionListFull();
    }

    private void nutritionListFull() {
        imageUrls.add(R.drawable.nitrogen);
        deficiencyNames.add("নাইট্রোজেনের ঘাটতি");

        imageUrls.add(R.drawable.phosphorus);
        deficiencyNames.add("ফসফরাস সারের ঘাটতি");

        imageUrls.add(R.drawable.potassium);
        deficiencyNames.add("পটাশ সারের ঘাটতি");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        Log.d(TAG, "cat.   --> " + category);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageUrls, deficiencyNames, category, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(NutritionActivity.this, UploadActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(NutritionActivity.this, UploadActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
