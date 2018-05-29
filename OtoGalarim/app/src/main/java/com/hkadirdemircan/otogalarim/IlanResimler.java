package com.hkadirdemircan.otogalarim;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hkadirdemircan.otogalarim.Models.ResimEklePojo;
import com.hkadirdemircan.otogalarim.RestApi.ManagerAll;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IlanResimler extends AppCompatActivity {

    Button resimSecButton, resimEkleButon, cikButon;
    ImageView secilenIlanResmiImageView;
    Bitmap bitmap;
    String uye_id, ilan_id, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_resimler);
        tanimla();

        // aktivite arasi gonderilen verileri almak icin kullanilir.
        // Ornek: uye_id, ilan_id
        Bundle bundle = getIntent().getExtras();
        uye_id = String.valueOf(bundle.getInt("uye_id"));
        ilan_id= bundle.getString("ilan_id");
    }

    /**
     * butonlari tanimliyoruz.
     *
     */
    public void tanimla()
    {
        resimSecButton = (Button) findViewById(R.id.resimSecButon);
        resimEkleButon = (Button) findViewById(R.id.resimEkleButon);
        cikButon = (Button) findViewById(R.id.cikButon);

        secilenIlanResmiImageView = (ImageView) findViewById(R.id.secilenIlanResmiImageView);

        //resim sec butonuna bastıgında galerisi acilmasi icin.
       resimSecButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               resimGoster();
           }
       });


       resimEkleButon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               yukle();
           }
       });

    }

    //web servise istek atarak yukleme islemi yapiyoruz.
    //Ve donen veriyi ekrana basiyoruz.
    public void yukle()
    {
        image = imageToString(); //String olarak image 'imizi aldik.
        final Call<ResimEklePojo> request = ManagerAll.getInstance().resimEkle(uye_id, ilan_id, image);;
        request.enqueue(new Callback<ResimEklePojo>() {
            @Override
            public void onResponse(Call<ResimEklePojo> call, Response<ResimEklePojo> response) {
                if(response.body().isTf())
                {
                    Toast.makeText(getApplicationContext(),response.body().getSonuc(), Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(getApplicationContext(),response.body().getSonuc(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<ResimEklePojo> call, Throwable t) {

            }
        });
    }

    //galeriyi acar
    public void resimGoster()
    {
        Intent ıntent = new Intent();
        ıntent.setType("image/*");
        ıntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(ıntent,777);

    }

    /**
     * Secilen resimi bitmap' e cevirir,
     * Bitmap'i de image ' e atip imageView'de gosterilmesi islemini yapiyor.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 777 && resultCode == RESULT_OK && data != null)
        {
            Uri path = data.getData();
            try
            {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                secilenIlanResmiImageView.setImageBitmap(bitmap);
                secilenIlanResmiImageView.setVisibility(View.VISIBLE);

            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * image base64 decode islemi.
     * @return image base64 String
     */
    public String imageToString()
    {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte [] byt = byteArrayOutputStream.toByteArray();
        String imageToString = Base64.encodeToString(byt, Base64.DEFAULT);
        return imageToString;

    }
}
