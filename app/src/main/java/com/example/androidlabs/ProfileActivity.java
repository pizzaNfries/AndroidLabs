package com.example.androidlabs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imageButton;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private TextView userEmail;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(ACTIVITY_NAME, "In function : onResume" );
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(ACTIVITY_NAME, "In function : onPause " );
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(ACTIVITY_NAME, "In function : onStop" );
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "In function : onDestroy");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        imageButton = findViewById(R.id.imageButton);
        userEmail = findViewById(R.id.email2);

        Intent intent = getIntent();
        String email = intent.getStringExtra("EMAIL");

        userEmail.setText(email);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                dispatchTakePictureIntent();
            }
        });
        Log.e(ACTIVITY_NAME, "In function : onCreate ");
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageButton mimagebutton= findViewById(R.id.imageButton);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mimagebutton.setImageBitmap(imageBitmap);
        }

        Log.e(ACTIVITY_NAME, "In function : onActivityResult " );

    }

}
