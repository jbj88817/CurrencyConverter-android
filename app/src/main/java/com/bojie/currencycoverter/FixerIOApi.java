package com.bojie.currencycoverter;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by bojiejiang on 10/9/15.
 */


    public interface FixerIOApi {

        @GET("latest")
        Call<Currency> getCurrency(@Query("base") String baseCurrency);
        //Call<List<Currency>> getCurrency(@Query("base") String baseCurrency, Callback<List<Currency>> callback);
    }



