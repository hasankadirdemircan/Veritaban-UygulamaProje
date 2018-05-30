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

/**
 * Created by Hkadir on 27.03.2018.
 */

public class ManagerAll extends BaseManager {

    private  static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){ return ourInstance; }

    /**
     *
     * @param ad
     * @param sifre
     * @return
     */
    public Call<LoginPojo> login(String ad , String sifre){

        Call<LoginPojo> x = getRestApi().control(ad, sifre);

        return x;
    }

    /**
     *
     * @param ad
     * @param sifre
     * @return
     */
    public Call<RegisterPojo> register(String ad , String sifre){

        Call<RegisterPojo> x = getRestApi().kayitol(ad, sifre);

        return x;
    }

    /**
     *
     * @param ad
     * @param kod
     * @return
     */
    public Call<DogrulamaPojo> dogrula(String ad , String kod){

        Call<DogrulamaPojo> x = getRestApi().dogrulama(ad, kod);

        return x;
    }


    /**
     *
     * @param uye_id
     * @param sehir
     * @param ilce
     * @param mahalle
     * @param marka
     * @param seri
     * @param model
     * @param yil
     * @param ilantipi
     * @param kimden
     * @param baslik
     * @param aciklama
     * @param motortipi
     * @param motorhacmi
     * @param surat
     * @param yakittipi
     * @param ortalamayakit
     * @param depohacmi
     * @param km
     * @return
     */
    public Call<IlanSonucPojo> ilanVer(String uye_id, String sehir, String ilce, String mahalle,
                                       String marka, String seri, String model, String yil,
                                       String ilantipi, String kimden, String baslik, String aciklama,
                                       String motortipi, String motorhacmi, String surat, String yakittipi,
                                       String ortalamayakit, String depohacmi, String km, String ucret ){

        Call<IlanSonucPojo> x = getRestApi().ilanVer(uye_id, sehir,ilce, mahalle, marka, seri,
                                                     model, yil, ilantipi, kimden, baslik, aciklama,
                                                     motortipi, motorhacmi, surat, yakittipi, ortalamayakit, depohacmi, km, ucret);

        return x;
    }


    /**
     * resim yukle RestApi cagirilip iste atilip sonuc doner.
     *
     * @param uye_id
     * @param ilan_id
     * @param image
     * @return
     */
    public Call<ResimEklePojo> resimEkle(String uye_id , String ilan_id, String image){

        Call<ResimEklePojo> x = getRestApi().resimYukle(uye_id, ilan_id, image);

        return x;
    }

    /**
     *bize list tipinde lazim oldugu icin list'e ceviridik.
     *
     * @param uyeid
     * @return
     */
    public Call<List<IlanlarimPojo>> ilanlarim(String uyeid ){

        Call<List<IlanlarimPojo>> x = getRestApi().ilanlarim(uyeid);

        return x;
    }


    /**
     *
     * @param ilanid
     * @return
     */
    public Call<IlanlarimSilPojo> ilanlarimSil(String ilanid ){

        Call<IlanlarimSilPojo> x = getRestApi().ilanlarimSil(ilanid);

        return x;
    }

    /**
     *
     * @return
     */
    public Call<List<IlanlarPojo>> ilanlar(){

        Call<List<IlanlarPojo>> x = getRestApi().ilanlar();

        return x;
    }


    /**
     *
     * @param ilanid
     * @return
     */
    public Call<IlanDetayPojo> ilanDetay(String ilanid ){

        Call<IlanDetayPojo> x = getRestApi().ilanDetay(ilanid);

        return x;
    }


}
