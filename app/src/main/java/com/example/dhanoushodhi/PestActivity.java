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
import android.view.View;
import android.widget.Button;

import com.example.dhanoushodhi.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class PestActivity extends AppCompatActivity {

    private static final String TAG = "PestActivity";

    private ArrayList<Integer> imageUrls = new ArrayList<Integer>();
    private ArrayList<String> pestNames = new ArrayList<>();
    private String category;

    Button btn_unknown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pest);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.bn_pests);
        setSupportActionBar(toolbar);
        category = toolbar.getTitle().toString();
        //Log.d(TAG, "cat.   --> " + category);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_unknown = findViewById(R.id.btn_unknown);

        btn_unknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PestActivity.this, UploadImagesActivity.class);
                intent.putExtra("unknown", "UNK");
                intent.putExtra("category", category);
                startActivity(intent);
                finish();
            }
        });

        pestListFull();
    }

    private void pestListFull() {
        imageUrls.add(R.drawable.gall_midge);
        pestNames.add("গল মাছি বা নলি মাছি");

        imageUrls.add(R.drawable.wbph);
        pestNames.add("সাদাপিঠ গাছফড়িং");

        imageUrls.add(R.drawable.grasshopper);
        pestNames.add("ঘাসফড়িং");

        imageUrls.add(R.drawable.riceleaf_folder);
        pestNames.add("পাতা মোড়ানো পোকা");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        Log.d(TAG, "cat.   --> " + category);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageUrls, pestNames, category, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(PestActivity.this, UploadActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(PestActivity.this, UploadActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
