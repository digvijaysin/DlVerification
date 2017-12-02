package com.example.shivanshu.driveeasy;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shivanshu on 4/29/2017.
 */

public class RetrofitObject {
    //static final String BASE_URL="http://zailet.com/zailet_internship_assignment/";
    public static RetrofitInterface getRetrofitObject(String BASE_URL)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RetrofitInterface.class);
    }

}
