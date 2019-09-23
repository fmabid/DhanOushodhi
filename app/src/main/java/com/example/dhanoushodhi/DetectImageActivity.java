package com.example.dhanoushodhi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class DetectImageActivity extends AppCompatActivity {

    int PICK_IMAGE = 1;
    public ArrayList<Uri> imgUriList;

    Button buttonGallery;
    Button buttonDetect;
    Button buttonDiseaseDetails;
    TextView tvDiseaseName;
    ImageView thumbnail;
    LinearLayout layout;

    String diseaseName;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detect_image);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("রোগ শনাক্ত করুন");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        buttonGallery = findViewById(R.id.btn_gallery);
        buttonDetect = findViewById(R.id.btn_upload);
        buttonDiseaseDetails = findViewById(R.id.btn_details_disease);
        tvDiseaseName = findViewById(R.id.tv_name);
        layout = findViewById(R.id.result_container);

        layout.setVisibility(View.GONE);

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        buttonDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
    }

    public void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            imgUriList = new ArrayList<Uri>();
            imgUriList.add(uri);

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                thumbnail = findViewById(R.id.iv_thumb);
                thumbnail.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImage() {
        if (imgUriList != null) {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            diseaseName = "লিফ স্কোল্ড";
            category = "রোগ";

            layout.setVisibility(View.VISIBLE);

            if (diseaseName != null) {
                tvDiseaseName.setText("রোগের নামঃ " + diseaseName);

                buttonDiseaseDetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(DetectImageActivity.this, DetailsActivity.class);
                        intent.putExtra("diseaseName", diseaseName);
                        intent.putExtra("category", category);
                        intent.putExtra("detect", "detect");
                        startActivity(intent);
                        finish();
                    }
                });
            }

            imgUriList.clear();
        } else {
            Toast.makeText(this, "কোন ছবি নির্বাচন করা হয়নি", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(DetectImageActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetectImageActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
