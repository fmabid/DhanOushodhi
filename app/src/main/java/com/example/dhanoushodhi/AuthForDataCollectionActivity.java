package com.example.dhanoushodhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AuthForDataCollectionActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText et_pin;
    Button btn_verify;
    TextView tv_warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_for_data_collection);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        et_pin = findViewById(R.id.et_pin);
        btn_verify = findViewById(R.id.btn_pin_submit);
        tv_warning = findViewById(R.id.tv_warning);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verified(et_pin.getText().toString())) {
                    Intent intent = new Intent(AuthForDataCollectionActivity.this, UploadActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    tv_warning.setText("আপনার কোডটি ভুল হয়েছে, দয়া করে আবার চেষ্টা করুন");
                }
            }
        });
    }

    private boolean verified(String pin) {
        if ("1234".equals(pin)) {
            return true;
        }

        return false;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(AuthForDataCollectionActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(AuthForDataCollectionActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
