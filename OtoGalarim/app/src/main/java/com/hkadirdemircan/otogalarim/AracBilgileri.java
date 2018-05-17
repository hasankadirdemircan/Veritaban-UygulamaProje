package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        markaBilgiEditText = (EditText) findViewById(R.id.mahalleBilgiEditText);
        seriBilgiEditText = (EditText) findViewById(R.id.seriBilgiEditText);
        modelBilgiEditText = (EditText) findViewById(R.id.modelBilgiEditText);
        yilBilgiEditText = (EditText) findViewById(R.id.yilBilgiEditText);
        kmBilgiEditText = (EditText) findViewById(R.id.kmBilgiEditText);

        aracBilgisiButon = (Button) findViewById(R.id.aracBilgisiButon);

        aracBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(AracBilgileri.this, MotorPerformans.class);
                startActivity(ıntent);
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                finish();
            }
        });

        aracBilgisiButonGeri = (Button)findViewById(R.id.aracBilgisiButonGeri);
        aracBilgisiButonGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(AracBilgileri.this, IlanTuru.class);
                startActivity(ıntent);
                //activity gecisine anim ekledik.
                overridePendingTransition(R.anim.anim_in_reverse,R.anim.anim_out_reverse);
                finish();
            }
        });
    }
}
