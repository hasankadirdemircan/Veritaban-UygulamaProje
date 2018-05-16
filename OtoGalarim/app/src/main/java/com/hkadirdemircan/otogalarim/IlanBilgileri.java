package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IlanBilgileri extends AppCompatActivity {

    Button ilanBilgisiButon;
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
        //butona tiklayinca diger activity acilacak.
        ilanBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(IlanBilgileri.this,AdresBilgileri.class);
                startActivity(ıntent);
            }
        });
    }
}
