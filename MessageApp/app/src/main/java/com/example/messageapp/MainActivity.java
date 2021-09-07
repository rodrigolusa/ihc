package com.example.messageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) (findViewById(R.id.txtMessage));
        Button btnSend = (Button) (findViewById(R.id.btnSend));
    }

    public void Send(View view) {
        String text2Send = text.getText().toString();
        Intent in = new Intent(MainActivity.this, MainActivity2.class);
        Bundle bundle = new Bundle();
        bundle.putString("message", text2Send);
        in.putExtras(bundle);

        startActivity(in);
    }
}