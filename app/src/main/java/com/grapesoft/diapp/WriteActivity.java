package com.grapesoft.diapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class WriteActivity extends AppCompatActivity {
    private static final String FILE_NAME = "diyet.txt";

    public TextView txtSonuclar;
    EditText Sabah, SabahAra, Oglen, OglenAra, Aksam, AksamAra;
    String DiyetText;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Sabah = findViewById(R.id.EditSabah);
        SabahAra = findViewById(R.id.EditSabahA);
        Oglen = findViewById(R.id.EditO);
        OglenAra = findViewById(R.id.EditOglenA);
        Aksam = findViewById(R.id.EditAksam);
        AksamAra = findViewById(R.id.EditAksamA);


        txtSonuclar = (TextView) findViewById(R.id.textHesaplamaSonuc);
        Intent i = getIntent();
        String Sonuclar = i.getStringExtra("degerler");
        txtSonuclar.setText(Sonuclar);



        backButton=findViewById(R.id.imageView6);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                /* finish();*/
            }
        });


    }

    public void save(View v) {
        DiyetText = "Sabah: " + Sabah.getText().toString() + '\n' + "Ara: " + SabahAra.getText().toString() + '\n' + "Öğlen: " + Oglen.getText().toString() + '\n' + "Ara: " + OglenAra.getText().toString() +
                '\n' + "Aksam: " + Aksam.getText().toString() + '\n' + "Ara: " + AksamAra.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(DiyetText.getBytes());
            Sabah.getText().clear();
            SabahAra.getText().clear();
            Oglen.getText().clear();
            OglenAra.getText().clear();
            Aksam.getText().clear();
            AksamAra.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void load(View v) {
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String Diyet;
            while ((Diyet = br.readLine()) != null) {
                sb.append(Diyet).append("\n");
            }
            String [] arrOfStr = sb.toString().split("\n");
            Sabah.setText(arrOfStr[0].replaceFirst("Sabah: ",""));
            SabahAra.setText(arrOfStr[1].replaceFirst("Ara: ",""));
            Oglen.setText(arrOfStr[2].replaceFirst("Öğlen: ",""));
            OglenAra.setText(arrOfStr[3].replaceFirst("Ara: ",""));
            Aksam.setText(arrOfStr[4].replaceFirst("Aksam: ",""));
            AksamAra.setText(arrOfStr[5].replaceFirst("Ara: ",""));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onClickWhatsApp(View view) {

        PackageManager pm = getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String WpMesaj="Sabah: " + Sabah.getText().toString() + '\n' + "Ara: " + SabahAra.getText().toString() + '\n' + "Öğlen: " + Oglen.getText().toString() + '\n' + "Ara: " + OglenAra.getText().toString() +
                    '\n' + "Aksam: " + Aksam.getText().toString() + '\n' + "Ara: " + AksamAra.getText().toString();

            if (Sabah.getText().toString().isEmpty() &&SabahAra.getText().toString().isEmpty()&&Oglen.getText().toString().isEmpty()  &&OglenAra.getText().toString().isEmpty()  &&Aksam.getText().toString().isEmpty()  &&AksamAra.getText().toString().isEmpty())
                Toast.makeText(this, "Lütfen veri giriniz", Toast.LENGTH_LONG).show();
            else{
            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, WpMesaj);
            startActivity(Intent.createChooser(waIntent, "Share with"));}

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }

}
