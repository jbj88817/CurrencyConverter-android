package com.bojie.currencycoverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    private EditText dollarField;

    // json object response url
    private String urlBaseUSD = "http://api.fixer.io/latest?base=USD";
    private double rateUsdToCny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getRates();

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
        double cny = rateUsdToCny * usd;
        DecimalFormat df = new DecimalFormat("#.00");
        Toast.makeText(this, "CNY: " + df.format(cny), Toast.LENGTH_LONG).show();
    }


    private void getRates(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                urlBaseUSD, (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String date = response.getString("date");
                    JSONObject rates = response.getJSONObject("rates");
                    rateUsdToCny = rates.getDouble("CNY");
                    Log.d("rateUsdToCny", rateUsdToCny+"");

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}
