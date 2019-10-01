package com.example.scannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int REQUEST_IMAGE = 1;
    static int GALLERY_IMAGE = 2;
    //ignore splash screen for now
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button photoBtn = findViewById(R.id.photoBtn);
        Button galleryBtn = findViewById(R.id.galleryBtn);

        photoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePictureIntent();
            }
        });
        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galleryPictureIntent();
            }
        });
    }

    private void takePictureIntent(){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePicture,REQUEST_IMAGE);
        }
    }
    private void galleryPictureIntent(){
        Intent galleryPicture = new Intent(Intent.ACTION_PICK);
        galleryPicture.setType("image/*");
        String[] mimeTypes = {"image/jpeg","image/png","image/jpg"};
        galleryPicture.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        if(galleryPicture.resolveActivity(getPackageManager())!=null){
            startActivityForResult(galleryPicture,GALLERY_IMAGE);
        }
    }
    @Override
    protected void onActivityResult(int request,int result,Intent data){
        if(request==REQUEST_IMAGE&&result==RESULT_OK){
            //result came from camera and result ok
            goToForm();
        }else if(request==GALLERY_IMAGE&&result==RESULT_OK){
            //result came from gallery and result ok
            goToForm();
        }
    }
    private void goToForm(){
        Intent goToFormIntent = new Intent(this,CameraPreview.class);
        startActivity(goToFormIntent);
    }
}
