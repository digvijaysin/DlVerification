package com.example.shivanshu.driveeasy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shivanshu on 4/29/2017.
 */

public interface RetrofitInterface {
    @GET("questions")
    public Call<BlogDetailsModalClass> getDLList(@Query("dlnumber") String s);
    @GET("questions")
    public Call<RcDataClass> getRcList(@Query("rcnumber") String  s);
}

