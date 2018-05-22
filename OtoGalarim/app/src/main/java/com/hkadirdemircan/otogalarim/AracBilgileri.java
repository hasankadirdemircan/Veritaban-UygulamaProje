package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hkadirdemircan.otogalarim.Models.IlanVerPojo;

public class AracBilgileri extends AppCompatActivity {

    Button aracBilgisiButon,aracBilgisiButonGeri;
    EditText markaBilgiEditText, seriBilgiEditText, modelBilgiEditText, yilBilgiEditText, kmBilgiEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_bilgileri);
        tanimla();
    }

    public void tanimla() {
        markaBilgiEditText = (EditText) findViewById(R.id.markaBilgiEditText);
        seriBilgiEditText = (EditText) findViewById(R.id.seriBilgiEditText);
        modelBilgiEditText = (EditText) findViewById(R.id.modelBilgiEditText);
        yilBilgiEditText = (EditText) findViewById(R.id.yilBilgiEditText);
            kmBilgiEditText = (EditText) findViewById(R.id.kmBilgiEditText);

        aracBilgisiButon = (Button) findViewById(R.id.aracBilgisiButon);

        //activity de geri dedigimizde girdigi bilgiler kalsin diye.
        markaBilgiEditText.setText(IlanVerPojo.getMarka());
        seriBilgiEditText.setText(IlanVerPojo.getSeri());
        modelBilgiEditText.setText(IlanVerPojo.getModel());
        yilBilgiEditText.setText(IlanVerPojo.getYil());
        kmBilgiEditText.setText(IlanVerPojo.getKm());


        aracBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!markaBilgiEditText.getText().toString().isEmpty() && !seriBilgiEditText.getText().toString().isEmpty() && !modelBilgiEditText.getText().toString().isEmpty()
                        &&!yilBilgiEditText.getText().toString().isEmpty() && !kmBilgiEditText.getText().toString().isEmpty())
                {
                    //textView de girilen bilgileri set ediyoruz.
                        IlanVerPojo.setMarka(markaBilgiEditText.getText().toString());
                        IlanVerPojo.setSeri(seriBilgiEditText.getText().toString());
                        IlanVerPojo.setModel(modelBilgiEditText.getText().toString());
                        IlanVerPojo.setYil(yilBilgiEditText.getText().toString());
                        IlanVerPojo.setKm(kmBilgiEditText.getText().toString());

                    Intent ıntent = new Intent(AracBilgileri.this, MotorPerformans.class);
                    startActivity(ıntent);
                    //ileri tusuna basinca animasyon icin
                    overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                    //ileri bastigimizda bi onceki activty acik kalmamasi icin
                    finish();
                }else
                {
                    Toast.makeText(getApplicationContext(),"Bilgileri Eksiksiz Giriniz",Toast.LENGTH_LONG).show();
                }

            }
        });

        aracBilgisiButonGeri = (Button)findViewById(R.id.aracBilgisiButonGeri);
        aracBilgisiButonGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(AracBilgileri.this, AdresBilgileri.class);
                startActivity(ıntent);
                //activity gecisine anim ekledik.
                overridePendingTransition(R.anim.anim_in_reverse,R.anim.anim_out_reverse);
                finish();
            }
        });
    }
}
