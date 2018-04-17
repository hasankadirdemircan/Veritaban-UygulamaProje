package com.hkadirdemircan.otogalarim.RestApi;


import com.hkadirdemircan.otogalarim.Models.DogrulamaPojo;
import com.hkadirdemircan.otogalarim.Models.LoginPojo;
import com.hkadirdemircan.otogalarim.Models.RegisterPojo;

import retrofit2.Call;

/**
 * Created by Hkadir on 27.03.2018.
 */

public class ManagerAll extends BaseManager {

    private  static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){ return ourInstance; }

    public Call<LoginPojo> login(String ad , String sifre){

        Call<LoginPojo> x = getRestApi().control(ad, sifre);

        return x;
    }

    public Call<RegisterPojo> register(String ad , String sifre){

        Call<RegisterPojo> x = getRestApi().kayitol(ad, sifre);

        return x;
    }

    public Call<DogrulamaPojo> dogrula(String ad , String kod){

        Call<DogrulamaPojo> x = getRestApi().dogrulama(ad, kod);

        return x;
    }

}
