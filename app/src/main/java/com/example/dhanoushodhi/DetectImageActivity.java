package com.example.dhanoushodhi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class DetectImageActivity extends AppCompatActivity {

    //Load the tensorflow inference library
    static {
        System.loadLibrary("tensorflow_inference");
    }

    //PATH TO OUR MODEL FILE AND NAMES OF THE INPUT AND OUTPUT NODES
    private String MODEL_PATH = "file:///android_asset/mobilenetv2.pb";
    private String INPUT_NAME = "input_2";
    private String OUTPUT_NAME = "output_1";
    private TensorFlowInferenceInterface tf;

    //ARRAY TO HOLD THE PREDICTIONS AND FLOAT VALUES TO HOLD THE IMAGE DATA
    float[] PREDICTIONS = new float[9];
    private float[] floatValues;
    private int[] INPUT_SIZE = {224,224,3};


    int PICK_IMAGE = 1;
    public ArrayList<Uri> imgUriList;

    Button buttonGallery;
    Button buttonDetect;
    Button buttonDiseaseDetails;
    TextView tvDiseaseName;
    TextView tvDiseaseNameOffline;
    ImageView thumbnail;
    LinearLayout layout;

    String diseaseName;
    String category;

    Snackbar progressBar;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detect_image);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("রোগ শনাক্ত করুন");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //initialize tensorflow with the AssetManager and the Model
        tf = new TensorFlowInferenceInterface(getAssets(),MODEL_PATH);


        buttonGallery = findViewById(R.id.btn_gallery);
        buttonDetect = findViewById(R.id.btn_upload);
        buttonDiseaseDetails = findViewById(R.id.btn_details_disease);
        tvDiseaseName = findViewById(R.id.tv_name);;
        tvDiseaseNameOffline = findViewById(R.id.tv_name_prediction);
        layout = findViewById(R.id.result_container);
        thumbnail = findViewById(R.id.iv_thumb);

        layout.setVisibility(View.GONE);

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });


        progressBar = Snackbar.make(thumbnail,"PROCESSING IMAGE",Snackbar.LENGTH_INDEFINITE);

        buttonDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //uploadImage();


                progressBar.show();
                predict(bmp);
            }
        });
    }

    //FUNCTION TO COMPUTE THE MAXIMUM PREDICTION AND ITS CONFIDENCE
    public Object[] argmax(float[] array){


        int best = -1;
        float best_confidence = 0.0f;

        for(int i = 0;i < array.length;i++){

            float value = array[i];

            if (value > best_confidence){

                best_confidence = value;
                best = i;
            }
        }

        return new Object[]{best,best_confidence};
    }

    @SuppressLint("StaticFieldLeak")
    public void predict(final Bitmap bitmap){
        //Runs inference in background thread
        new AsyncTask<Integer,Integer,Integer>(){
            @Override
            protected Integer doInBackground(Integer ...params){

                //Resize the image into 224 x 224
                Bitmap resized_image = ImageUtils.processBitmap(bitmap,224);

                //Normalize the pixels
                floatValues = ImageUtils.normalizeBitmap(resized_image,224,127.5f,1.0f);

                //Pass input into the tensorflow
                tf.feed(INPUT_NAME,floatValues,1,224,224,3);

                //compute predictions
                tf.run(new String[]{OUTPUT_NAME});

                //copy the output into the PREDICTIONS array
                tf.fetch(OUTPUT_NAME,PREDICTIONS);
                System.out.println(Arrays.toString(PREDICTIONS));

                //Obtained highest prediction
                Object[] results = argmax(PREDICTIONS);


                int class_index = (Integer) results[0];
                float confidence = (Float) results[1];


                try{
                    final String conf = String.valueOf(confidence * 100).substring(0,5);
                    //Convert predicted class index into actual label name
                    final String label = ImageUtils.getLabel(getAssets().open("labels.json"),class_index);

                    diseaseName = label;
                    //Display result on UI
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //Log.d("res", "run: ----->"+label);
                            progressBar.dismiss();
                            tvDiseaseNameOffline.setText("রোগের নামঃ " + label);
                        }
                    });
                }
                catch (Exception e){
                }
                return 0;
            }
        }.execute(0);


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
                bmp = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));


                thumbnail.setImageBitmap(bmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImage() {
        if (imgUriList != null) {
            /*try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }*/

            diseaseName = "ধানের পাতা ব্লাস্ট";
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
