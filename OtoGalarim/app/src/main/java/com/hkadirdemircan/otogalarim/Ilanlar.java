package com.hkadirdemircan.otogalarim;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hkadirdemircan.otogalarim.Adapters.IlanlarAdapter;
import com.hkadirdemircan.otogalarim.Models.IlanlarPojo;
import com.hkadirdemircan.otogalarim.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ilanlar extends AppCompatActivity {

    ListView listView;
    List<IlanlarPojo> ılanlarPojoList;
   IlanlarAdapter ılanlarAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlar);
        listView = findViewById(R.id.ilanlarListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ıntent = new Intent(Ilanlar.this, IlanDetay.class);

                ıntent.putExtra("ilanid",ılanlarPojoList.get(i).getIlanid());
                startActivity(ıntent);

            }
        });
        ilanlarimiGoruntule();
    }

    public void ilanlarimiGoruntule() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("İlanlar");
        progressDialog.setMessage("İlanlar Listeleniyor, Lütfen Bekleyin ... ");
        progressDialog.setCancelable(false);//iptal edilebilriligi kapatiyor.Sebebi arkada islemler yapiliyor.
        progressDialog.show();

        Call<List<IlanlarPojo>> request = ManagerAll.getInstance().ilanlar();
        request.enqueue(new Callback<List<IlanlarPojo>>() {
           @Override
           public void onResponse(Call<List<IlanlarPojo>> call, Response<List<IlanlarPojo>> response) {
               if(response.isSuccessful())
               {
                   if(response.body().get(0).isTf())
                   {
                        ılanlarPojoList = response.body();
                        ılanlarAdapter = new IlanlarAdapter(ılanlarPojoList, getApplicationContext());
                        listView.setAdapter(ılanlarAdapter);
                        Toast.makeText(getApplicationContext(),response.body().get(0).getSayi()+ " tane ilan listelenmiştir.",Toast.LENGTH_LONG).show();
                       progressDialog.cancel();

                   }

               }
           }

           @Override
           public void onFailure(Call<List<IlanlarPojo>> call, Throwable t) {

           }
       });

    }
}

