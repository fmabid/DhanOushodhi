package com.example.dhanoushodhi;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.dhanoushodhi.adapters.GalleryAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

public class UploadImagesActivity extends AppCompatActivity {
    private static final String TAG = "UploadImagesActivity";

    private final static String DISEASE_SELECTED = "diseaseName";
    private final static String CATEGORY = "category";
    private final static String UNK = "unknown";

    String disease;
    String category_name;
    String unknown;

    /*  Variables for image select & uploading purpose  */
    private Button btn;
    private Button btn_upload;
    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    List<String> imagesEncodedList;
    private GridView gvGallery;
    private GalleryAdapter galleryAdapter;
    public ArrayList<Uri> mArrayUri;

    //Firebase
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_images);

        if (getIntent().getStringExtra(UNK)!=null) {
            category_name = "অজানা";
            disease = getIntent().getStringExtra(CATEGORY);
        } else {
            disease = getIntent().getStringExtra(DISEASE_SELECTED);
            category_name = getIntent().getStringExtra(CATEGORY);
        }
        // Log.d(TAG, "onCreate called.   --> " + disease );

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(disease);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        btn = findViewById(R.id.btn);
        btn_upload = findViewById(R.id.btn_upload);
        gvGallery = (GridView)findViewById(R.id.gv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);
            }
        });

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            // When an Image is picked
            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && null != data) {
                // Get the Image from data

                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                imagesEncodedList = new ArrayList<String>();
                if(data.getData()!=null){

                    Uri mImageUri=data.getData();

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(mImageUri,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imageEncoded  = cursor.getString(columnIndex);
                    cursor.close();

                    mArrayUri = new ArrayList<Uri>();
                    mArrayUri.add(mImageUri);
                    galleryAdapter = new GalleryAdapter(getApplicationContext(),mArrayUri);
                    gvGallery.setAdapter(galleryAdapter);
                    gvGallery.setVerticalSpacing(gvGallery.getHorizontalSpacing());
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) gvGallery.getLayoutParams();
                    mlp.setMargins(0, gvGallery.getHorizontalSpacing(), 0, 0);

                } else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        mArrayUri = new ArrayList<Uri>();

                        for (int i = 0; i < mClipData.getItemCount(); i++) {

                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            Log.v("LOG_TAG", "Selected Images URI ---> " +  uri);
                            mArrayUri.add(uri);
                            // Get the cursor
                            Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
                            // Move to first row
                            cursor.moveToFirst();

                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            imageEncoded  = cursor.getString(columnIndex);
                            imagesEncodedList.add(imageEncoded);
                            cursor.close();

                            galleryAdapter = new GalleryAdapter(getApplicationContext(),mArrayUri);
                            gvGallery.setAdapter(galleryAdapter);
                            gvGallery.setVerticalSpacing(gvGallery.getHorizontalSpacing());
                            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) gvGallery.getLayoutParams();
                            mlp.setMargins(0, gvGallery.getHorizontalSpacing(), 0, 0);
                        }
                        Log.v("LOG_TAG", "Selected Images " + mArrayUri.size() + " " + mArrayUri.get(1).getPath() + " ----> " + mArrayUri);
                    }
                }
            } else {
                Toast.makeText(this, "কোন ছবি নির্বাচন করা হয়নি", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void uploadImage() {

        if (mArrayUri != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("আপলোড হচ্ছে...");
            progressDialog.show();

            for (int i = 0; i < mArrayUri.size(); i++) {
                StorageReference ref = storageReference.child(category_name + "/" + disease + "/" + mArrayUri.get(i).getPath().replace("document/", ""));
                ref.putFile(mArrayUri.get(i)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        Toast.makeText(UploadImagesActivity.this, "আপলোড হয়েছে ", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(UploadImagesActivity.this, "আপলোড হয়নি" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.v("LOG_TAG", "Failed n" + e.getMessage());
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                .getTotalByteCount());
                        progressDialog.setMessage("আপলোড হয়েছে " + (int) progress + "%");
                    }
                });
            }
        } else {
            Toast.makeText(this, "কোন ছবি নির্বাচন করা হয়নি", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ("অজানা".equals(category_name)) {
            if ("রোগ".equals(disease)) {
                Intent intent = new Intent(UploadImagesActivity.this, DiseaseActivity.class);
                startActivity(intent);
                finish();
            } else if ("কীট".equals(disease)) {
                Intent intent = new Intent(UploadImagesActivity.this, PestActivity.class);
                startActivity(intent);
                finish();
            } else if ("পুষ্টি দুর্বলতা".equals(disease)) {
                Intent intent = new Intent(UploadImagesActivity.this, NutritionActivity.class);
                startActivity(intent);
                finish();
            }
        } else {
            if ("রোগ".equals(category_name)) {
                Intent intent = new Intent(UploadImagesActivity.this, DiseaseActivity.class);
                startActivity(intent);
                finish();
            } else if ("কীট".equals(category_name)) {
                Intent intent = new Intent(UploadImagesActivity.this, PestActivity.class);
                startActivity(intent);
                finish();
            } else if ("পুষ্টি দুর্বলতা".equals(category_name)) {
                Intent intent = new Intent(UploadImagesActivity.this, NutritionActivity.class);
                startActivity(intent);
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ("অজানা".equals(category_name)) {
                if ("রোগ".equals(disease)) {
                    Intent intent = new Intent(UploadImagesActivity.this, DiseaseActivity.class);
                    startActivity(intent);
                    finish();
                } else if ("কীট".equals(disease)) {
                    Intent intent = new Intent(UploadImagesActivity.this, PestActivity.class);
                    startActivity(intent);
                    finish();
                } else if ("পুষ্টি দুর্বলতা".equals(disease)) {
                    Intent intent = new Intent(UploadImagesActivity.this, NutritionActivity.class);
                    startActivity(intent);
                    finish();
                }
            } else {
                if ("রোগ".equals(category_name)) {
                    Intent intent = new Intent(UploadImagesActivity.this, DiseaseActivity.class);
                    startActivity(intent);
                    finish();
                } else if ("কীট".equals(category_name)) {
                    Intent intent = new Intent(UploadImagesActivity.this, PestActivity.class);
                    startActivity(intent);
                    finish();
                } else if ("পুষ্টি দুর্বলতা".equals(category_name)) {
                    Intent intent = new Intent(UploadImagesActivity.this, NutritionActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
