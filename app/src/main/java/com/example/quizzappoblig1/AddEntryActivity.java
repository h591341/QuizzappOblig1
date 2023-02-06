package com.example.quizzappoblig1;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import com.example.quizzappoblig1.utils.Camera;


public class AddEntryActivity extends AppCompatActivity {

    File file;
    Camera camera;
    Bitmap bm;
    ImageView imageView;
    ImageButton addPicture;

    static final int REQUEST_IMAGE_CAPTURE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);



     //   addPicture.setVisibility(View.INVISIBLE);

       // camera = new Camera(this, this);

        Button addPicture = findViewById(R.id.addPicture);
        addPicture.setOnClickListener(v -> {
            camera.takePicture();
        });





        //addPicture.setOnClickListener((v) -> {
        //    if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
        //        ActivityCompat.requestPermissions(AddEntryActivity.this, new String[]{READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        //    }
        //});


        EditText pictureText = findViewById(R.id.pictureName);
        pictureText.setOnClickListener(this::showSoftKeyboard);

        Button submitEntry = findViewById(R.id.submitEntry);
        submitEntry.setOnClickListener((v) -> {

            HashMap<String, Image> entryPair = new HashMap<>();
           // entryPair.put(pictureText, picture);
        });
    }
    public void showSoftKeyboard(View view) {
        if(view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

 /**   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            try {
                String path = camera.createFilename();

                file = camera.createImageFile(path);
                Uri photoURI = FileProvider.getUriForFile(this, this.getPackageName() + "provider", file);

                data.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                bm = (Bitmap) data.getExtras().get("data");

                imageView.setImageBitmap(scaledBM(bm));

             //   addPicture.setVisability(View.INVISIBLE);
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
    }
    public Bitmap scaledBM(Bitmap bm) {
        return Bitmap.createScaledBitmap(bm, 450, 500, true);
 */
}
