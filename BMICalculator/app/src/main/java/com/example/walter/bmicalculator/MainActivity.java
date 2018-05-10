package com.example.walter.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        final EditText massText = (EditText) findViewById(R.id.massText);
        final EditText heightText = (EditText) findViewById(R.id.heightText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mass = Double.parseDouble(massText.getText().toString());
                double height = Double.parseDouble(heightText.getText().toString());
                double bmi = mass / (height * height);
                TextView bmiValue = (TextView) findViewById(R.id.bmiValue);
                bmiValue.setText(bmi + "");
                if(bmi > 25) {
                    bmiValue.setTextColor(getResources().getColor(R.color.colorOver));
                } else if(bmi < 18.5) {
                    bmiValue.setTextColor(getResources().getColor(R.color.colorUnder));
                } else {
                    bmiValue.setTextColor(getResources().getColor(R.color.colorRight));
                }
            }
        });
    }
}
