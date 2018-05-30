package com.hkadirdemircan.otogalarim.RestApi;

import com.hkadirdemircan.otogalarim.Models.DogrulamaPojo;
import com.hkadirdemircan.otogalarim.Models.IlanDetayPojo;
import com.hkadirdemircan.otogalarim.Models.IlanSonucPojo;
import com.hkadirdemircan.otogalarim.Models.IlanlarPojo;
import com.hkadirdemircan.otogalarim.Models.IlanlarimPojo;
import com.hkadirdemircan.otogalarim.Models.IlanlarimSilPojo;
import com.hkadirdemircan.otogalarim.Models.LoginPojo;
import com.hkadirdemircan.otogalarim.Models.RegisterPojo;
import com.hkadirdemircan.otogalarim.Models.ResimEklePojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Hkadir on 27.03.2018.
 */

public interface RestApi {
    @FormUrlEncoded
    @POST("/login.php")
    Call<LoginPojo> control(@Field("kad") String ad, @Field("soyad") String sifre);

    @FormUrlEncoded
    @POST("/register.php")
    Call<RegisterPojo> kayitol(@Field("kadi") String ad, @Field("sifre") String sifre);

    @FormUrlEncoded
    @POST("/dogrulama.php")
    Call<DogrulamaPojo> dogrulama(@Field("kadi") String ad, @Field("kod") String kod);

    //post istegi atacagimiz url ve parametreler .
    @FormUrlEncoded
    @POST("/ilanver.php")
    Call<IlanSonucPojo> ilanVer(@Field("uye_id") String uye_id, @Field("sehir") String sehir, @Field("ilce") String ilce, @Field("mahalle") String mahalle,
                                @Field("marka") String marka, @Field("seri") String seri, @Field("model") String model, @Field("yil") String yil,
                                @Field("ilantipi") String ilantipi, @Field("kimden") String kimden, @Field("baslik") String baslik, @Field("aciklama") String aciklama,
                                @Field("motortipi") String motortipi, @Field("motorhacmi") String motorhacmi, @Field("surat") String surat, @Field("yakittipi") String yakittipi,
                                @Field("ortalamayakit") String ortalamayakit, @Field("depohacmi") String depohacmi, @Field("km") String km, @Field("ucret") String ucret);


    @FormUrlEncoded
    @POST("/ilanresmiekle.php")
    Call<ResimEklePojo> resimYukle(@Field("uye_id") String uye_id, @Field("ilan_id") String ilan_id, @Field("resim") String base64StringResim);


    //sadece uye adi atip, bilgileri cekecegiz.
    @GET("/ilanlarim.php")
    Call<List<IlanlarimPojo>> ilanlarim(@Query("uyeid") String uyeid);


    @GET("/ilanlarimdansil.php")
    Call<IlanlarimSilPojo> ilanlarimSil(@Query("ilan_id") String ilanid);

    @GET("/ilanlar.php")
    Call<List<IlanlarPojo>> ilanlar();

    @GET("/ilandetay.php")
    Call<IlanDetayPojo> ilanDetay(@Query("ilanid") String ilanid);
}
