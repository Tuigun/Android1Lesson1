package com.example.android1lesson1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android1lesson1.databinding.ActivityMain3Binding;


public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.changeBv.setOnClickListener(v -> {
            String result_text = binding.editText3.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("key", result_text);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

}