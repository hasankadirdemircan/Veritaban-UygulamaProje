package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdresBilgileri extends AppCompatActivity {

    Button adresBilgisiButon;
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

        adresBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(AdresBilgileri.this, AracBilgileri.class);
                startActivity(ıntent);
            }
        });
    }
}
