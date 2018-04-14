package com.hkadirdemircan.otogalarim.RestApi;

import com.hkadirdemircan.otogalarim.Models.LoginPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Hkadir on 27.03.2018.
 */

public interface RestApi {
    @FormUrlEncoded
    @POST("/login.php")
    Call<LoginPojo> control(@Field("kad") String ad, @Field("soyad") String soyad);
}
