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

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private EditText dollarField;
    private CurrencyRestAdapter mCurrencyRestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrencyRestAdapter = new CurrencyRestAdapter();
        getNowCurrencyForMain("USD");


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
    }

    public void btnConvert(View view) {

        btnConvertClicked();

    }

    private void btnConvertClicked() {
        double usd = Double.parseDouble(dollarField.getText().toString());
        //Log.i("dollarField", dollarField.getText().toString());
        double cny = Utils.uSDToCNY(usd);
        DecimalFormat df = new DecimalFormat("#.00");
        Toast.makeText(this, "CNY: " + df.format(cny), Toast.LENGTH_LONG).show();
    }

    private void getNowCurrencyForMain(String base) {
        try {
            mCurrencyRestAdapter.getNowCurrency(base, new Callback() {
                @Override
                public void onResponse(Response response, Retrofit retrofit) {
                    Currency currency = (Currency) response.body();
                    Log.d("!!!!!", currency.getRates().getCNY()+"");
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.i("onFailure", t.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
