package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MotorPerformans extends AppCompatActivity {

    Button motorBilgisiButon;
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

        motorBilgisiButon = (Button)findViewById(R.id.motorBilgisiButon);
        motorBilgisiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(MotorPerformans.this,Yakit.class);
                startActivity(ıntent);
            }
        });
    }
}
