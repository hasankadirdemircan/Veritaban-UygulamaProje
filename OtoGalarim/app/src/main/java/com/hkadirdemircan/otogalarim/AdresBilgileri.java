package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hkadirdemircan.otogalarim.Models.IlanVerPojo;

public class AdresBilgileri extends AppCompatActivity {

    Button adresBilgisiButon,adresBilgisiButonGeri;
    EditText sehirBilgiEditText,ilceBilgiEditText,mahalleBilgiEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adres_bilgileri);
        tanimla();
    }

    public void tanimla()
    {
        adresBilgisiButon = (Button)findViewById(R.id.adresBilgisiButon);
        sehirBilgiEditText = (EditText)findViewById(R.id.sehirBilgiEditText);
        ilceBilgiEditText = (EditText)findViewById(R.id.ilceBilgiEditText);
        mahalleBilgiEditText = (EditText)findViewById(R.id.mahalleBilgiEditText);

        //geri butonuna tikladiginda girdigi bilgileri get ile cekip ekrana set ediyoruz.
        sehirBilgiEditText.setText(IlanVerPojo.getSehir());
        ilceBilgiEditText.setText(IlanVerPojo.getIlce());
        mahalleBilgiEditText.setText(IlanVerPojo.getMahalle());

        adresBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!sehirBilgiEditText.getText().toString().isEmpty() && !ilceBilgiEditText.getText().toString().isEmpty() && !mahalleBilgiEditText.getText().toString().isEmpty())
                {
                    //textView de girilen bilgileri set ediyoruz.
                    IlanVerPojo.setSehir(sehirBilgiEditText.getText().toString());
                    IlanVerPojo.setIlce(ilceBilgiEditText.getText().toString());
                    IlanVerPojo.setMahalle(mahalleBilgiEditText.getText().toString());

                    Intent ıntent = new Intent(AdresBilgileri.this, AracBilgileri.class);
                    startActivity(ıntent);
                    overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                    //ileri tusuna basinca bu activty arkada calismasin bitsin diye.
                    finish();
                }else
                {
                    Toast.makeText(getApplicationContext(),"Bilgileri Eksiksiz Giriniz",Toast.LENGTH_LONG).show();
                }

            }
        });

        adresBilgisiButonGeri = (Button)findViewById(R.id.adresBilgisiButonGeri);
        adresBilgisiButonGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(AdresBilgileri.this,IlanTuru.class);
                startActivity(ıntent);
                overridePendingTransition(R.anim.anim_in_reverse,R.anim.anim_out_reverse);
                //geri tusuna bastiginda bulundugu activity arkada durmasin.
                finish();
            }
        });
    }
}
