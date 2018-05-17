package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class IlanTuru extends AppCompatActivity {

    Spinner ilanturuSpinner,kimdenSpinner;
    Button ilanTuruButton,ilanTuruButtonGeri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_turu);
        tanimla();
    }

    public void tanimla()
    {
        ilanturuSpinner = (Spinner)findViewById(R.id.ilanturuSpinner);
        kimdenSpinner = (Spinner)findViewById(R.id.kimdenSpinner);

        ilanTuruButton = (Button) findViewById(R.id.ilanTuruButton);
        ilanTuruButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(IlanTuru.this,AdresBilgileri.class );
                startActivity(ıntent);
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                finish();
            }
        });

        ilanTuruButtonGeri = (Button) findViewById(R.id.ilanTuruButtonGeri);
        ilanTuruButtonGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(IlanTuru.this, IlanBilgileri.class);
                startActivity(ıntent);
                //geri butonu icin slayt gecisi
                overridePendingTransition(R.anim.anim_in_reverse,R.anim.anim_out_reverse);
                //suanki activity degisince bunu kapat.
                finish();
            }
        });
    }
}
