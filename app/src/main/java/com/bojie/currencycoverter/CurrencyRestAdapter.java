package com.bojie.currencycoverter;

import java.io.IOException;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by bojiejiang on 10/11/15.
 */
public class CurrencyRestAdapter {

    public static final String API_URL = "https://api.fixer.io/";

    private FixerIOApi mFixerIOApi;

    public CurrencyRestAdapter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mFixerIOApi = retrofit.create(FixerIOApi.class);
    }

    public void getNowCurrency(String base, Callback callback) throws IOException {
        mFixerIOApi.getCurrency(base);
    }

}
