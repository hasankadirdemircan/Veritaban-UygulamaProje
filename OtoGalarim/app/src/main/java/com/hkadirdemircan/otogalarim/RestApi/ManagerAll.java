package com.hkadirdemircan.otogalarim.RestApi;

import com.hkadirdemircan.otogalarim.Models.LoginPojo;
import com.hkadirdemircan.otogalarim.Models.RegisterPojo;

import retrofit2.Call;

/**
 * Created by Hkadir on 27.03.2018.
 */

public class ManagerAll extends BaseManager {

    private  static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){ return ourInstance; }

    public Call<LoginPojo> login(String ad , String soyad){

        Call<LoginPojo> x = getRestApi().control(ad, soyad);

        return x;
    }

    public Call<RegisterPojo> register(String ad , String soyad){

        Call<RegisterPojo> x = getRestApi().kayitol(ad, soyad);

        return x;
    }

}
