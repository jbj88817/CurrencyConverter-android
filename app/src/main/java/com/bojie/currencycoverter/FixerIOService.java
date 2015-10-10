package com.bojie.currencycoverter;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by bojiejiang on 10/9/15.
 */


    public interface FixerIOService {

        @GET("/latest")
        Call<List<Currency>> getCurrency(@Query("base") String baseCurrency);
        //Call<List<Currency>> getCurrency(@Query("base") String baseCurrency, Callback<List<Currency>> callback);
    }



