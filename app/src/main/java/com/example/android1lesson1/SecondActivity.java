package com.example.android1lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android1lesson1.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ImageView camera_iv;
    private ImageView contact_iv;
    private ImageView google_iv;
   // private ActivitySecondBinding binding;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        camera_iv = findViewById(R.id.camera_btn);
        contact_iv = findViewById(R.id.contact_btn);
        google_iv = findViewById(R.id.google_btn);
        textView = findViewById(R.id.textView);
    }

    public void onClick_iv(View view) {
        switch (view.getId()) {
            case R.id.camera_btn:
                //     Intent intent = new Intent("android.me-*dia.action.IMAGE_CAPTURE");
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // startActivity(intent);
                startActivityForResult(intent, 1);
                break;
            case R.id.contact_btn:
                Intent intentContact = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                        startActivity(intentContact);
                break;
            case R.id.google_btn:
                String urlString = "https://www.google.com/?hl=ru";

                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                startActivity(intent2);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK)
            textView.setText(data.getStringExtra("key"));
    }

    public void onClick(View view) {
        Intent intent_btn = new Intent(SecondActivity.this, MainActivity3.class);
        startActivityForResult(intent_btn,1);
    }
}