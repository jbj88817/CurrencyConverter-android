package com.bojie.currencycoverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dollarField;

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
    }

    public void btnConvert(View view) {

       btnConvertClicked();

    }

    private void btnConvertClicked(){
        double usd = Double.parseDouble(dollarField.getText().toString());
        //Log.i("dollarField", dollarField.getText().toString());
        double cny = Utils.uSDToCNY(usd);
        Toast.makeText(this, "CNY: " + cny, Toast.LENGTH_LONG).show();
    }

}
