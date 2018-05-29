package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hkadirdemircan.otogalarim.Models.IlanVerPojo;

public class IlanBilgileri extends AppCompatActivity {

    Button ilanBilgisiButon,ilanBilgisiButonGeri;
    EditText ilanBaslikEditText,ilanAciklamaEditText, ilanFiyatEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_bilgileri);
        tanimla();
    }

    public void tanimla()
    {
        ilanAciklamaEditText = (EditText)findViewById(R.id.ilanAciklamaEditText);
        ilanBaslikEditText = (EditText)findViewById(R.id.ilanBaslikEditText);
        ilanFiyatEditText = (EditText) findViewById(R.id.ilanFiyatEditText);

        ilanBilgisiButon = (Button)findViewById(R.id.ilanBilgisiButon);
        ilanBilgisiButonGeri = (Button)findViewById(R.id.ilanBilgisiButonGeri);

        //kullanici ileri deyip geri geldiginde girdigi bilgiler kaybolmasin diye.
        ilanAciklamaEditText.setText(IlanVerPojo.getAciklama());
        ilanBaslikEditText.setText(IlanVerPojo.getBaslik());
        ilanFiyatEditText.setText(IlanVerPojo.getUcret());

        //butona tiklayinca diger activity acilacak.
        ilanBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Eger aciklamalari doldurmadiysa text alanları bostur ve bir sonraki activity'e gecemesin diye if.
                if(!ilanAciklamaEditText.getText().toString().equals("") && !ilanBaslikEditText.getText().toString().equals("") && !ilanFiyatEditText.getText().toString().equals("")) {

                    //kullanici ileri deyip geri geldiginde girdigi bilgiler kaybolmasin diye.
                    //girilen bilgileri set ediyoruz..
                    IlanVerPojo.setAciklama(ilanAciklamaEditText.getText().toString());
                    IlanVerPojo.setBaslik(ilanBaslikEditText.getText().toString());
                    IlanVerPojo.setUcret(ilanFiyatEditText.getText().toString());

                    //IlanTuru classina gec
                    Intent ıntent = new Intent(IlanBilgileri.this, IlanTuru.class);
                    startActivity(ıntent);
                    //activity giris cikis anim ekledik.
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                    finish();
                }else
                {
                    Toast.makeText(getApplicationContext(),"Tüm Bilgileri Eksiksiz Giriniz.",Toast.LENGTH_LONG).show();
                }

            }
        });

        ilanBilgisiButonGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(IlanBilgileri.this,MainActivity.class);
                startActivity(ıntent);
                overridePendingTransition(R.anim.anim_in_reverse,R.anim.anim_out_reverse);
                finish();
            }
        });
    }
}
