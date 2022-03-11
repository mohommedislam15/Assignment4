package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    EditText checkAmountValue,partySizeValue;
    Button buttonCompute;
    TextView fifteenPercentTipValue,twentyPercentTipValue,twentyfivePercentTipValue,
            fifteenPercentTotalValue,twentyPercentTotalValue,twentyfivePercentTotalValue;

    float Bill, People, afterSplit;
    String CheckValue, PartySize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        buttonCompute = findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckValue = checkAmountValue.getText().toString();
                PartySize = partySizeValue.getText().toString();

                if (CheckValue.length() <= 0 || PartySize.length() <= 0 || PartySize.length() > CheckValue.length()) {
                    displayToast();
                    }
                else{
                    Bill = Integer.parseInt(CheckValue);
                    People = Integer.parseInt(PartySize);

                    if (People == 0)
                        afterSplit = Bill;
                    else
                        afterSplit = (Bill / People);

                }
                fifteenPercentTipValue.setText(calculateTip(.15));
                twentyPercentTipValue.setText(calculateTip(.20));
                twentyfivePercentTipValue.setText(calculateTip(.25));
                fifteenPercentTotalValue.setText(calculateTotalPerPerson(.15));
                twentyPercentTotalValue.setText(calculateTotalPerPerson(.20));
                twentyfivePercentTotalValue.setText(calculateTotalPerPerson(.25));

            }
        });
    }

    public String calculateTip(double percent){
        String Tip;
        double temp = (Bill * percent) / (Integer.parseInt(partySizeValue.getText().toString()));
        Tip = "" + Math.round(temp);
        return Tip;
    }
    public String calculateTotalPerPerson(double percent){
        String Total;
        Double temp = Double.parseDouble(calculateTip(percent));
        double perPerson = Bill/People;
        Total = "" + Math.round(temp+perPerson);
        return Total;
    }
    public void displayToast() {
        Toast.makeText(this, "Empty or Incorrect value(s)!", Toast.LENGTH_LONG).show();
    }
}
