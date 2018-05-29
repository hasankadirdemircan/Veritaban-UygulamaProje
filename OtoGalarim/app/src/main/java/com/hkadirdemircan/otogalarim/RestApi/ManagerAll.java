package com.hkadirdemircan.otogalarim.RestApi;


import com.hkadirdemircan.otogalarim.Models.DogrulamaPojo;
import com.hkadirdemircan.otogalarim.Models.IlanSonucPojo;
import com.hkadirdemircan.otogalarim.Models.LoginPojo;
import com.hkadirdemircan.otogalarim.Models.RegisterPojo;
import com.hkadirdemircan.otogalarim.Models.ResimEklePojo;

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
                                       String ortalamayakit, String depohacmi, String km ){

        Call<IlanSonucPojo> x = getRestApi().ilanVer(uye_id, sehir,ilce, mahalle, marka, seri,
                                                     model, yil, ilantipi, kimden, baslik, aciklama,
                                                     motortipi, motorhacmi, surat, yakittipi, ortalamayakit, depohacmi, km);

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
}
