package com.example.quizzappoblig1;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class AddEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        Button addPicture = findViewById(R.id.addPicture);
        addPicture.setOnClickListener((v) -> {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(AddEntryActivity.this, new String[]{READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
            }
        });
        EditText pictureText = findViewById(R.id.pictureName);
        pictureText.setOnClickListener(this::showSoftKeyboard);

        Button submitEntry = findViewById(R.id.submitEntry);
        submitEntry.setOnClickListener((v) -> {

            HashMap<String, Image> entryPair = new HashMap<>();
            entryPair.put(pictureText, picture);
        });
    }
    public void showSoftKeyboard(View view) {
        if(view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}