package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Yakit extends AppCompatActivity {

    Button yakitTuketimBilgisiButon,yakitTuketimBilgisiButonGeri;
    EditText yakitTipiBilgiEditText, ortalamaYakitBilgiEditText, depoHacmiBilgiEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yakit);
        tanimla();
    }

    public void tanimla()
    {
        yakitTipiBilgiEditText = (EditText) findViewById(R.id.yakitTipiBilgiEditText);
        ortalamaYakitBilgiEditText = (EditText)findViewById(R.id.ortalamaYakitBilgiEditText);
        depoHacmiBilgiEditText = (EditText)findViewById(R.id.depoHacmiBilgiEditText);

        yakitTuketimBilgisiButon = (Button) findViewById(R.id.yakitTuketimBilgisiButon);
        yakitTuketimBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(Yakit.this,IlanResimler.class);
                startActivity(ıntent);
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                finish();
            }
        });

        yakitTuketimBilgisiButonGeri = (Button)findViewById(R.id.yakitTuketimBilgisiButonGeri);
        yakitTuketimBilgisiButonGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(Yakit.this,MotorPerformans.class);
                startActivity(ıntent);
                //geri tusuna bastiginda slayt icin.
                overridePendingTransition(R.anim.anim_in_reverse, R.anim.anim_out_reverse);
                finish();
            }
        });
    }
}
