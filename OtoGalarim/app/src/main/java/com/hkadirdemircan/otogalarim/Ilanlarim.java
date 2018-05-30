package com.hkadirdemircan.otogalarim;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.hkadirdemircan.otogalarim.Adapters.IlanlarimAdapter;
import com.hkadirdemircan.otogalarim.Models.IlanlarimPojo;
import com.hkadirdemircan.otogalarim.Models.IlanlarimSilPojo;
import com.hkadirdemircan.otogalarim.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ilanlarim extends AppCompatActivity {

    ListView listView;
    IlanlarimAdapter ılanlarimAdapter;
    List<IlanlarimPojo> ılanlarimPojos;
    SharedPreferences sharedPreferences;
    String uye_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlarim);
        listView = findViewById(R.id.ilanlarimListView);
        sharedPreferences = getApplicationContext().getSharedPreferences("session", 0);//uye_id almak icin.
        uye_id = sharedPreferences.getString("uye_id",null);
        ilanlarimiGoruntule();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               ilanlarimAlertDialog(Ilanlarim.this, ılanlarimPojos.get(i).getIlanid());
            }
        });
    }

    public void ilanlarimiGoruntule()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("İlanlarım");
        progressDialog.setMessage("İlanlarınız Yükleniyor, Lütfen Bekleyin ... ");
        progressDialog.setCancelable(false);//iptal edilebilriligi kapatiyor.Sebebi arkada islemler yapiliyor.
        progressDialog.show();


        ılanlarimPojos = new ArrayList<>();

        Call<List<IlanlarimPojo>> request = ManagerAll.getInstance().ilanlarim(uye_id);
        request.enqueue(new Callback<List<IlanlarimPojo>>() {
            @Override
            public void onResponse(Call<List<IlanlarimPojo>> call, Response<List<IlanlarimPojo>> response) {

                if(response.isSuccessful())
                {
                    //eger hic ilan yoksa main activity' e don
                    ılanlarimPojos = response.body();
                    if(response.body().get(0).isTf())
                    {
                        ılanlarimAdapter = new IlanlarimAdapter(ılanlarimPojos,getApplicationContext(),Ilanlarim.this);
                        listView.setAdapter(ılanlarimAdapter);

                        Toast.makeText(getApplicationContext(),response.body().get(0).getSayi()+ " tane ilanınız bulunmaktadır.",Toast.LENGTH_LONG).show();
                        progressDialog.cancel();
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "İlanınız bulunmaktadır...",Toast.LENGTH_LONG).show();
                        progressDialog.cancel();
                        Intent ıntent = new Intent(Ilanlarim.this, MainActivity.class);
                        startActivity(ıntent);
                        //activity gecisine anim ekledik.
                        overridePendingTransition(R.anim.anim_in_reverse,R.anim.anim_out_reverse);
                        finish();
                    }

                }

            }

            @Override
            public void onFailure(Call<List<IlanlarimPojo>> call, Throwable t) {

            }
        });

    }


    public void ilanlarimAlertDialog(Activity activity, final String ilan_id)
    {
        LayoutInflater ınflater  = activity.getLayoutInflater();
        View view = ınflater.inflate(R.layout.alertlayout,null);

        Button button = (Button) view.findViewById(R.id.buton);
        Button buttonCık = (Button) view.findViewById(R.id.buton2);

        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setView(view);
        alert.setCancelable(false);
        final AlertDialog dialog = alert.create();

        buttonCık.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sil(ilan_id);
                dialog.cancel();
            }
        });
        dialog.show();
    }

    public void sil(String ilanid)
    {
        Call<IlanlarimSilPojo> request = ManagerAll.getInstance().ilanlarimSil(ilanid);
        request.enqueue(new Callback<IlanlarimSilPojo>() {
            @Override
            public void onResponse(Call<IlanlarimSilPojo> call, Response<IlanlarimSilPojo> response) {
                if(response.body().isTf())
                {
                    ilanlarimiGoruntule();
                }
            }

            @Override
            public void onFailure(Call<IlanlarimSilPojo> call, Throwable t) {

            }
        });
    }
}
