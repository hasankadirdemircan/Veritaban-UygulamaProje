package com.hkadirdemircan.otogalarim;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.hkadirdemircan.otogalarim.Models.IlanDetayPojo;
import com.hkadirdemircan.otogalarim.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IlanDetay extends AppCompatActivity {

    private TextView ilandetayBaslik, ilandetayFiyat, ilandetayMarka, ilandetayModel, ilandetaySeri, ilandetayYil,
            ilandetayIlanTipi, ilandetayKimden, ilandetayMotorTipi, ilandetayMotorHacmi, ilandetaySurat, ilandetayYakitTipi,
            ilandetayOrtalamaYakit, ilandetayDepoHacmi, ilandetayKm;
    private Button ilandetayAciklamaButon, ilandetayFavoriyeAlButon;
    private ViewPager ilandetaySlider;
    String ilanId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_detay);
        Bundle bundle = getIntent().getExtras();
        ilanId = bundle.getString("ilanid");
        tanimla();
        getIlanDetay();
    }

    public void tanimla()
    {
        ilandetayBaslik = (TextView)findViewById(R.id.ilandetayBaslik);
        ilandetayFiyat = (TextView)findViewById(R.id.ilandetayFiyat);
        ilandetayMarka = (TextView)findViewById(R.id.ilandetayMarka);
        ilandetayModel = (TextView)findViewById(R.id.ilandetayModel);

        ilandetaySeri = (TextView)findViewById(R.id.ilandetaySeri);
        ilandetayYil = (TextView)findViewById(R.id.ilandetayYil);
        ilandetayIlanTipi = (TextView)findViewById(R.id.ilandetayIlanTipi);
        ilandetayKimden = (TextView)findViewById(R.id.ilandetayKimden);

        ilandetayMotorTipi = (TextView)findViewById(R.id.ilandetayMotorTipi);
        ilandetayMotorHacmi = (TextView)findViewById(R.id.ilandetayMotorHacmi);
        ilandetaySurat = (TextView)findViewById(R.id.ilandetaySurat);
        ilandetayYakitTipi = (TextView)findViewById(R.id.ilandetayYakitTipi);

        ilandetayOrtalamaYakit = (TextView)findViewById(R.id.ilandetayOrtalamaYakit);
        ilandetayDepoHacmi = (TextView)findViewById(R.id.ilandetayDepoHacmi);
        ilandetayKm = (TextView)findViewById(R.id.ilandetayKm);

        ilandetayAciklamaButon = (Button) findViewById(R.id.ilandetayAciklamaButon);
        ilandetayFavoriyeAlButon = (Button) findViewById(R.id.ilandetayFavoriyeAlButon);

        ilandetaySlider = (ViewPager) findViewById(R.id.ilandetaySlider);

    }

    public void getIlanDetay()
    {
        final Call<IlanDetayPojo> request = ManagerAll.getInstance().ilanDetay(ilanId);
        request.enqueue(new Callback<IlanDetayPojo>() {
            @Override
            public void onResponse(Call<IlanDetayPojo> call, Response<IlanDetayPojo> response) {
                ilandetayBaslik.setText(response.body().getBaslik().toString());
                ilandetayFiyat.setText(response.body().getUcret().toString());
                ilandetayMarka.setText(response.body().getMahalle().toString());
                ilandetayModel.setText(response.body().getModel().toString());

                ilandetaySeri.setText(response.body().getSeri().toString());
                ilandetayYil.setText(response.body().getYil().toString());
                ilandetayIlanTipi.setText(response.body().getIlantipi().toString());
                ilandetayKimden.setText(response.body().getKimden().toString());

                ilandetayMotorTipi.setText(response.body().getMotortipi().toString());
                ilandetayMotorHacmi.setText(response.body().getMotorhacmi().toString());
                ilandetaySurat.setText(response.body().getSurat().toString());
                ilandetayYakitTipi.setText(response.body().getYakittipi().toString());

                ilandetayOrtalamaYakit.setText(response.body().getOrtalamayakit().toString());
                ilandetayDepoHacmi.setText(response.body().getDepohacmi().toString());
                ilandetayKm.setText(response.body().getKm().toString());
            }

            @Override
            public void onFailure(Call<IlanDetayPojo> call, Throwable t) {

            }
        });
    }
}
