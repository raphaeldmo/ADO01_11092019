package com.br.ado01_11092019;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();

        TextView textResultado = findViewById(R.id.txtResultado);

        textResultado.setText(intent.getExtras().getString("retorno"));



    }
}
