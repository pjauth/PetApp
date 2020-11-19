package com.patrickauth.petapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class PetProfRegistrationActivity extends Activity {
    final int petTypeACThreshold = 1;
    ImageView petProfPic;
    Button back, camera, gallery;
    protected String[] pet_types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_profile_registration);
        ButtonHandler bh =  new ButtonHandler();

        pet_types = getResources().getStringArray(R.array.pet_types);

        back = findViewById(R.id.pet_creation_form_back);
        back.setOnClickListener(bh);

        camera = findViewById(R.id.pet_pic_camera_btn);
        camera.setOnClickListener(bh);

        gallery = findViewById(R.id.pet_pic_gallery_btn);
        gallery.setOnClickListener(bh);

        petProfPic = (ImageView) findViewById(R.id.imageView);

        ArrayAdapter<String> petTypeAdaptor = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, pet_types);
        AutoCompleteTextView autoCompletePetType = (AutoCompleteTextView) findViewById(R.id.pet_type_autocomplete);
        autoCompletePetType.setThreshold(petTypeACThreshold);
        autoCompletePetType.setAdapter(petTypeAdaptor);
        autoCompletePetType.setTextColor(Color.BLACK);
    }

    // TODO: if someone could fix this thatd be cool :) idk what to do - conor
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    petProfPic.setImageBitmap(bitmap);

                    String path = android.os.Environment.getExternalStorageDirectory() + File.separator + "Phoenix" + File.separator + "default";
                    boolean deleted = f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");

                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };

                try {
                    // Ensure image isn't null
                    Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                    c.moveToFirst();
                    int columnIndex = c.getColumnIndex(filePath[0]);
                    String picturePath = c.getString(columnIndex);
                    c.close();
                    Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                    Log.w("MA", "File path for image from gallery: " + picturePath);
                    petProfPic.setImageBitmap(thumbnail);
                    petProfPic.setVisibility(View.VISIBLE);
                } catch (NullPointerException e){
                    Log.w("ERR", "Null pointer exception thrown when uploading image from gallery");
                    // Handle null image
                    Intent intent = new Intent(this, PetProfRegistrationActivity.class);
                    startActivity(intent);
                }
            }
        }
    }

    private void go_back_to_intro(){

        Intent intent = new Intent(this, IntroPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,0);

    }

    private void takePictureFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        startActivityForResult(intent, 1);
    }

    private void uploadPictureFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){

            switch(v.getId()){

                case R.id.pet_creation_form_back:
                    go_back_to_intro();
                    break;
                case R.id.pet_pic_camera_btn:
                    takePictureFromCamera();
                    break;
                case R.id.pet_pic_gallery_btn:
                    uploadPictureFromGallery();
                    break;
            }
        }

    }
}
