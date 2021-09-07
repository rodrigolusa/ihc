package com.example.sumapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumber, secondNumber;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText) (findViewById(R.id.firstNumber));
        secondNumber = (EditText) (findViewById(R.id.secondNumber));
        Button btnSum = (Button) (findViewById(R.id.btnSum));

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(firstNumber.getText().toString());
                double n2 = Double.parseDouble(secondNumber.getText().toString());
                double sum = n1 + n2;
                Toast.makeText(MainActivity.this, "Resultado: " + sum, Toast.LENGTH_LONG).show();
                TextView txtResult = (TextView) (findViewById(R.id.txtResult));
                txtResult.setText("Resultado: " + String.valueOf(sum));
            }
        });
    }
}