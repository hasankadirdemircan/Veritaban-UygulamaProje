package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IlanBilgileri extends AppCompatActivity {

    Button ilanBilgisiButon,ilanBilgisiButonGeri;
    EditText ilanBaslikEditText,ilanAciklamaEditText;
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
        ilanBilgisiButon = (Button)findViewById(R.id.ilanBilgisiButon);
        ilanBilgisiButonGeri = (Button)findViewById(R.id.ilanBilgisiButonGeri);

        //butona tiklayinca diger activity acilacak.
        ilanBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(IlanBilgileri.this,IlanTuru.class);
                startActivity(ıntent);
                //activity giris cikis anim ekledik.
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                finish();

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
