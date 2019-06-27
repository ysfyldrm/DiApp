package com.grapesoft.diapp;


import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;



public class MainActivity extends AppCompatActivity {

    ImageView backButton;

    private int countHesapla = 0;

    private InterstitialAd mInterstitialAd;

    public void startWritePage(){
        Intent intent = new Intent(MainActivity.this,WriteActivity.class);
        intent.putExtra("degerler",toplamTextv.getText().toString());
        startActivity(intent);
    }

    public void Clear(){

        degisimSütText.setText("");
        degisimEtText.setText("");
        degisimEygText.setText("");
        degisimSebzeText.setText("");
        degisimMeyveText.setText("");
        degisimYagText.setText("");
        degisimBaklagilText.setText("");

    }

public Button btnHesapla,btnTemizle;
public EditText yuzdeCHOv,yuzdePROv,yuzdeYAGv,degisimSütText,toplamTextv,degisimEtText,degisimEygText,degisimSebzeText,degisimMeyveText,degisimYagText,degisimBaklagilText;
public TextView sutCHOv,sutProv,sutYagv,etCHOv,etProv,etYagv,eygCHOv,eygProv,eygYagv,sebzeCHOv,sebzeProv,sebzeYagv,meyveCHOv,meyveProv,meyveYagv,yagCHOv,yagProv,yagYagv,baklagilCHOv,baklagilProv,baklagilYagv,textSüt,textEt,textEYG,textSebze,textMeyve,textYag,textBaklagil;
       AdView mAdView,mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        MobileAds.initialize(this, "ca-app-pub-3547428000724022~5187056659");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3547428000724022/5122570911");
        final AdRequest request = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mInterstitialAd.loadAd(request);

        mAdView2 = new AdView(this);
        mAdView2 = findViewById(R.id.adView2);
        AdRequest topAdRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView2.loadAd(topAdRequest);

        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.SMART_BANNER);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);
*/

        btnHesapla = (Button) findViewById(R.id.buttonHesapla);
        btnTemizle = (Button) findViewById(R.id.buttonTemizle);

        degisimSütText      =(EditText) findViewById(R.id.degisimSut);
        degisimEtText       =(EditText) findViewById(R.id.degisimEt);
        degisimEygText      =(EditText) findViewById(R.id.degisimEYG);
        degisimSebzeText    =(EditText) findViewById(R.id.degisimSebze);
        degisimMeyveText    =(EditText) findViewById(R.id.degisimMeyve);
        degisimYagText      =(EditText) findViewById(R.id.degisimYag);
        degisimBaklagilText =(EditText) findViewById(R.id.degisimBaklagil);
        toplamTextv         =(EditText) findViewById(R.id.toplamText);
        yuzdeCHOv           =(EditText) findViewById(R.id.yuzdeCHO);
        yuzdePROv           =(EditText) findViewById(R.id.yuzdePRO);
        yuzdeYAGv           =(EditText) findViewById(R.id.yuzdeYAG);

        sutCHOv =(TextView) findViewById(R.id.sütCHO);
        sutProv =(TextView) findViewById(R.id.sütPRO);
        sutYagv =(TextView) findViewById(R.id.sütYAG);

        etCHOv =(TextView) findViewById(R.id.etCHO);
        etProv =(TextView) findViewById(R.id.etPRO);
        etYagv =(TextView) findViewById(R.id.etYAG);

        eygCHOv =(TextView) findViewById(R.id.eygCHO);
        eygProv =(TextView) findViewById(R.id.eygPRO);
        eygYagv =(TextView) findViewById(R.id.eygYAG);

        sebzeCHOv =(TextView) findViewById(R.id.sebzeCHO);
        sebzeProv =(TextView) findViewById(R.id.sebzePRO);
        sebzeYagv =(TextView) findViewById(R.id.sebzeYAG);

        meyveCHOv =(TextView) findViewById(R.id.meyveCHO);
        meyveProv =(TextView) findViewById(R.id.meyvePRO);
        meyveYagv =(TextView) findViewById(R.id.meyveYAG);

        yagCHOv =(TextView) findViewById(R.id.yagCHO);
        yagProv =(TextView) findViewById(R.id.yagPRO);
        yagYagv =(TextView) findViewById(R.id.yagYAG);

        baklagilCHOv =(TextView) findViewById(R.id.baklagilCHO);
        baklagilProv =(TextView) findViewById(R.id.baklagilPRO);
        baklagilYagv =(TextView) findViewById(R.id.baklagilYAG);

        backButton=findViewById(R.id.imageView3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        btnHesapla.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(final View view){
                                              if (countHesapla==3){
                                                  if (mInterstitialAd.isLoaded()){
                                                      mInterstitialAd.show();
                                                      countHesapla = 0;
                                                  }
                                              }
                                              else{
                                                  countHesapla ++;
                                              }

                                              AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                                              builder.setCancelable(true);
                                              builder.setTitle("HESAPLAMA SONUÇLARI");
                                              builder.setMessage(toplamTextv.getText());

                                              builder.setNegativeButton("DİYET YAZ", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialogInterface, int which) {
                                                      startWritePage();
                                                  }
                                              });
                                              builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialog, int which) {

                                                  }
                                              });

                                              builder.show();
                                          }
                                      }
        );

        btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Clear();
            }
        });

        Thread t=new Thread(){


            @Override
            public void run(){

                while(!isInterrupted()){

                    try {
                        Thread.sleep(500);  //1000ms = 1 sec

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                final int sutCHOtop = Integer.parseInt(sutCHOv.getText().toString());
                                final int sutPROtop = Integer.parseInt(sutProv.getText().toString());
                                final int sutYAGtop = Integer.parseInt(sutYagv.getText().toString());
                                final int etPROtop = Integer.parseInt(etProv.getText().toString());
                                final int etYAGtop = Integer.parseInt(etYagv.getText().toString());
                                final int eygCHOtop = Integer.parseInt(eygCHOv.getText().toString());
                                final int eygPROtop = Integer.parseInt(eygProv.getText().toString());
                                final int sbzCHOtop = Integer.parseInt(sebzeCHOv.getText().toString());
                                final int sbzPROtop = Integer.parseInt(sebzeProv.getText().toString());
                                final int myvCHOtop = Integer.parseInt(meyveCHOv.getText().toString());
                                final int yagYAGtop = Integer.parseInt(yagYagv.getText().toString());
                                final int bklCHOtop = Integer.parseInt(baklagilCHOv.getText().toString());
                                final int bklPROtop = Integer.parseInt(baklagilProv.getText().toString());

                                final int topCHO = 4*(sutCHOtop + eygCHOtop + sbzCHOtop + myvCHOtop + bklCHOtop);
                                final int topPRO = 4*(sutPROtop + etPROtop + eygPROtop + sbzPROtop + bklPROtop);
                                final int topYAG = 9*(sutYAGtop + etYAGtop + yagYAGtop);
                                final double topTOPLAM = topCHO + topPRO + topYAG;

                                DecimalFormat df = new DecimalFormat("#.##");
                                yuzdeCHOv.setText(" % " + df.format((topCHO/topTOPLAM)*100));
                                yuzdePROv.setText(" % " + df.format((topPRO/topTOPLAM)*100));
                                yuzdeYAGv.setText(" % " + df.format((topYAG/topTOPLAM)*100));

                                toplamTextv.setText("KARBONHİDRAT = " + topCHO + " kcal  " + yuzdeCHOv.getText() +"\n" + "\n" +
                                        "PROTEİN = " + topPRO + " kcal  " + yuzdePROv.getText() + "\n" + "\n" +
                                        "YAĞ = " + topYAG + " kcal  " + yuzdeYAGv.getText() + "\n" + "\n" +
                                        "TOPLAM KALORİ = " + topTOPLAM + " kcal");


                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        t.start();


        degisimSütText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    count = s.length();
                    int re=1;
                    String value= degisimSütText.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    if(count>0){
                        sutCHOv.setText(""+finalValue*9);
                        sutProv.setText(""+finalValue*6);
                        sutYagv.setText(""+finalValue*6);

                    }
                    else { sutCHOv.setText(""+re*9);
                        sutProv.setText(""+re*6);
                        sutYagv.setText(""+re*6);
                    }
                }
                catch(NumberFormatException e) {
                    sutCHOv.setText("" + 9);
                    sutProv.setText("" + 6);
                    sutYagv.setText("" + 6);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        degisimEtText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int count=s.length();
                    int re=1;
                    String value= degisimEtText.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    if(count>0){
                        etProv.setText(""+finalValue*6);
                        etYagv.setText(""+finalValue*5);
                    }
                    else {
                        etProv.setText(""+re*6);
                        etYagv.setText(""+re*5);
                    }
                }
                catch(NumberFormatException e)
                {
                    etProv.setText(""+6);
                    etYagv.setText(""+5);
                }
            }
        });



        degisimEygText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int count=s.length();
                    int re=1;
                    String value= degisimEygText.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    if(count>0){
                        eygCHOv.setText(""+finalValue*15);
                        eygProv.setText(""+finalValue*2);

                    }
                    else {
                        eygCHOv.setText(""+re*15);
                        eygProv.setText(""+re*2);
                    }
                }
                catch(NumberFormatException e)
                {
                    eygCHOv.setText(""+15);
                    eygProv.setText(""+2);
                }
            }
        });


        degisimSebzeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int count=s.length();
                    int re=1;
                    String value= degisimSebzeText.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    if(count>0){
                        sebzeCHOv.setText(""+finalValue*6);
                        sebzeProv.setText(""+finalValue*1);
                    }
                    else {
                        sebzeCHOv.setText(""+re*6);
                        sebzeProv.setText(""+re*1);
                    }
                }
                catch(NumberFormatException e)
                {
                    sebzeCHOv.setText(""+6);
                    sebzeProv.setText(""+1);
                }
            }
        });



        degisimMeyveText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int count=s.length();
                    int re=1;
                    String value= degisimMeyveText.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    if(count>0){
                        meyveCHOv.setText(""+finalValue*15);

                    }
                    else {
                        meyveCHOv.setText(""+re*15);
                    }
                }
                catch(NumberFormatException e)
                {
                    meyveCHOv.setText(""+15);
                }
            }
        });



        degisimYagText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int count=s.length();
                    int re=1;
                    String value= degisimYagText.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    if(count>0){
                        yagYagv.setText(""+finalValue*5);
                    }
                    else {
                        yagYagv.setText(""+re*5);
                    }
                }
                catch(NumberFormatException e)
                {
                    yagYagv.setText(""+5);
                }
            }
        });



        degisimBaklagilText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int count=s.length();
                    int re=1;
                    String value= degisimBaklagilText.getText().toString();
                    int finalValue=Integer.parseInt(value);
                    if(count>0){
                        baklagilCHOv.setText(""+finalValue*15);
                        baklagilProv.setText(""+finalValue*5);
                    }
                    else {
                        baklagilCHOv.setText(""+re*15);
                        baklagilProv.setText(""+re*5);
                    }
                }
                catch(NumberFormatException e)
                {
                    baklagilCHOv.setText(""+15);
                    baklagilProv.setText(""+5);
                }
            }
        });
    }
}
