package com.grapesoft.diapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class WriteActivity extends AppCompatActivity {

    public void storeScreenshot(Bitmap bitmap, String filename) {
        String path = Environment.getExternalStorageDirectory().toString() + "/" + filename;
        OutputStream out = null;
        File imageFile = new File(path);

        try {
            out = new FileOutputStream(imageFile);
            // choose JPEG format
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
        } catch (FileNotFoundException e) {
            // manage exception ...
        } catch (IOException e) {
            // manage exception ...
        } finally {

            try {
                if (out != null) {
                    out.close();
                }

            } catch (Exception exc) {
            }

        }
    }

    private ImageView imageView;
    public TextView txtSonuclar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        imageView = (ImageView) findViewById(R.id.imageView);

        txtSonuclar = (TextView) findViewById(R.id.textHesaplamaSonuc);

        Intent i = getIntent();
        String Sonuclar = i.getStringExtra("degerler");

        txtSonuclar.setText(Sonuclar);

        Button buttonBack = (Button) findViewById(R.id.btnBack);
        Button buttonSS = (Button) findViewById(R.id.btnSS);
        buttonSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap b = Screenshot.takescreenshotOfRootView(imageView);
                storeScreenshot(b,"Diyetlerim");

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
