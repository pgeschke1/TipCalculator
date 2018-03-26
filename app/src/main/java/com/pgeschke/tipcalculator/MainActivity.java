package com.pgeschke.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double mealCost = 0;
    double tipPercentage;
    double tipAmount;
    String tipAmountString;
    String tipResultPrep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText costOfMeal = (EditText)findViewById(R.id.txtCost);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button tipCalculate = (Button)findViewById(R.id.btnCalculate);
        tipCalculate.setOnClickListener(new View.OnClickListener() {
            final TextView tipResult = ((TextView)findViewById(R.id.txtTip));
            @Override
            public void onClick(View view) {
                mealCost = Double.parseDouble(costOfMeal.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.00");
                tipPercentage = Double.parseDouble(group.getSelectedItem().toString());
                tipAmount = (mealCost * (tipPercentage/100));
                tipAmountString = String.valueOf(tipAmount);
                tipResultPrep = "Tip Amount: " + currency.format(tipAmount);
                tipResult.setText(tipResultPrep);

            }
        });

    }
}
