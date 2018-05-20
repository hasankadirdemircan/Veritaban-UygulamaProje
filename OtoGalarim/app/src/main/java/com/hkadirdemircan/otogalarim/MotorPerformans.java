package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hkadirdemircan.otogalarim.Models.IlanVerPojo;

public class MotorPerformans extends AppCompatActivity {

    Button motorBilgisiButon,motorBilgisiButonGeri;
    EditText motorTipiBilgiEditText, motorHacmiBilgiEditText, azamiSuratBilgiEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_performans);
        tanimla();
    }

    public void tanimla()
    {
        motorTipiBilgiEditText = (EditText)findViewById(R.id.motorTipiBilgiEditText);
        motorHacmiBilgiEditText = (EditText)findViewById(R.id.motorHacmiBilgiEditText);
        azamiSuratBilgiEditText = (EditText)findViewById(R.id.azamiSuratBilgiEditText);

        //set edilen bilgiler geri tusuyla dondugumuzde bilgileri text'e yazar.
        //IlanVerPojo static oldugu icin degerlere erisimde sikinti yasanmaz.
        motorTipiBilgiEditText.setText(IlanVerPojo.getMotortipi());
        motorHacmiBilgiEditText.setText(IlanVerPojo.getMotorhacmi());
        azamiSuratBilgiEditText.setText(IlanVerPojo.getSurat());


        motorBilgisiButon = (Button)findViewById(R.id.motorBilgisiButon);
        motorBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!motorTipiBilgiEditText.getText().toString().isEmpty() && !motorHacmiBilgiEditText.getText().toString().isEmpty() && !azamiSuratBilgiEditText.getText().toString().isEmpty())
                {
                    //bilgilerin set edilmesi geri dondugumuzde bilgiler kaybolmasın
                    IlanVerPojo.setMotortipi(motorTipiBilgiEditText.getText().toString());
                    IlanVerPojo.setMotorhacmi(motorHacmiBilgiEditText.getText().toString());
                    IlanVerPojo.setSurat(azamiSuratBilgiEditText.getText().toString());

                    Intent ıntent = new Intent(MotorPerformans.this,Yakit.class);
                    startActivity(ıntent);
                    overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                    finish();
                }else
                {
                    Toast.makeText(getApplicationContext(),"Bilgileri Eksiksiz Giriniz",Toast.LENGTH_LONG).show();
                }

            }
        });

        motorBilgisiButonGeri = (Button)findViewById(R.id.motorBilgisiButonGeri);
        motorBilgisiButonGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(MotorPerformans.this,AracBilgileri.class);
                startActivity(ıntent);
                overridePendingTransition(R.anim.anim_in_reverse,R.anim.anim_out_reverse);
                finish();
            }
        });
    }
}
