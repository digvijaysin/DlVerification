package com.example.shivanshu.driveeasy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shivanshu on 4/29/2017.
 */

public interface RetrofitInterface {
    @GET("questions")
    public Call<BlogDetailsModalClass> getDLList(@Query("dl_number") String s);

    @GET("questions")
    public Call<RcDataClass> getRcList(@Query("rc_number") String  s);

    @GET("questions")
    public Call<BlogDetailsModalClass> getPoliceIdList(@Query("police_id") String  s);
    @GET("questions")
    public Call<AadharDetailClass> getAadharDetails(@Query("aadhar_number") String s);
}

