package net.nicoledambra.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static final double DOLLAR_TO_POUNDS = 0.7670;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convertButton = findViewById(R.id.convertButton);
        final EditText amountText = findViewById(R.id.currencyEditText);


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;
                double convertedNum = 0;
                try {
                    convertedNum = Double.parseDouble(amountText.getText().toString()) * DOLLAR_TO_POUNDS;
                } catch(NumberFormatException nfe){
                    Log.e("Invalid", "Could not parse "+nfe);
                    valid = false;
                }

                ;
                if(valid) {
                    String strDouble = String.format(Locale.getDefault(),"%.2f",convertedNum);
                    Toast.makeText(MainActivity.this, "$" + amountText.getText().toString() + " is £" + strDouble, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Invalid entry", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
