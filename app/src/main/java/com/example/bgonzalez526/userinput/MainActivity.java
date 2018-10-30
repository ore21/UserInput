package com.example.bgonzalez526.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
import java.util.Currency;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    double costOfMeal = 0.00;
    double T_Error;
    double TotalTip;
    String TipChoice;
    double TipPercent;
    String fm_Total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Cost = (EditText)findViewById(R.id.Txt_Entry);
        final Spinner spn_opts = (Spinner)findViewById(R.id.Spn_Opts);
        Button charges = (Button)findViewById(R.id.Btn_Calc);
        charges.setOnClickListener(new View.OnClickListener() {

            final TextView result = ((TextView)findViewById(R.id.Txt_Result));
            @Override
                public void onClick(View v) {
                try{
                costOfMeal = Double.parseDouble(Cost.getText().toString());
                DecimalFormat currency = new DecimalFormat("$####,###.##");

                TipChoice = spn_opts.getSelectedItem().toString();
                TipPercent = Double.parseDouble(TipChoice.replaceAll("[^0-9]",""));

                TotalTip = ((costOfMeal) * (TipPercent / 100));

//                TotalOfMeal = Integer.parseInt(currency.getCurrency(R.id.Txt_Entry));
//                DecimalFormat Total = new DecimalFormat("$####,###.##");
                fm_Total = currency.format(TotalTip);

                result.setText("Total Tip: " + fm_Total  + " Tip Percent: " + TipChoice);
            }catch (Exception e){
                result.setText("ERROR, Please enter a number!");
        }
    }
});
}
}