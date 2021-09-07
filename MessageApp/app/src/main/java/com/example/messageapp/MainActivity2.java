package com.example.messageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        message = (TextView) (findViewById(R.id.txtMessage));
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("message");

        message.setText(data);
    }
}