package com.bojie.currencycoverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String API_URL = "https://api.fixer.io/";

    EditText dollarField;
    FixerIOService mFixerioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dollarField = (EditText) findViewById(R.id.editText);
        dollarField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            btnConvertClicked();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        // Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mFixerioService = retrofit.create(FixerIOService.class);


//        mFixerioService.getCurrency("USD", new Callback<Currency>() {
//            @Override
//            public void onResponse(Response<Currency> response, Retrofit retrofit) {
//                Currency currency = response.body();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });

//         mFixerioService.getCurrency("USD", new Callback<List<Currency>>() {
//            @Override
//            public void onResponse(Response<List<Currency>> response, Retrofit retrofit) {
//                List<Currency> currencyList = response.body();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });

        Call<List<Currency>> call = mFixerioService.getCurrency("USD");
        call.enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Response<List<Currency>> response, Retrofit retrofit) {
                if (response.isSuccess()){
                    List<Currency> currencyList = response.body();
                    for (Currency currency:currencyList) {
                        Log.d("!!!!!!!", currency.getBase());
                    }
                } else {
                    try {
                        Log.e("Response error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


    }

    public void btnConvert(View view) {

       btnConvertClicked();

    }

    private void btnConvertClicked(){
        double usd = Double.parseDouble(dollarField.getText().toString());
        //Log.i("dollarField", dollarField.getText().toString());
        double cny = Utils.uSDToCNY(usd);
        DecimalFormat df = new DecimalFormat("#.00");
        Toast.makeText(this, "CNY: " + df.format(cny), Toast.LENGTH_LONG).show();
    }

}
