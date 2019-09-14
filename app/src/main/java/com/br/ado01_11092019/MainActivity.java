package com.br.ado01_11092019;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sh = getSharedPreferences("temperatura",MODE_PRIVATE); //"TEMEPRATURA" E O NOME , N O ID
        Double Number = Double.parseDouble(sh.getString("temperatura", ""));
        TextView rt = findViewById(R.id.txtRetorno);
        if (Number != null){
            rt.setText("Última temperatura registrada :  " + Number);
        }
    }
    public void goSalvar (View v){
        EditText textTemperatura= findViewById(R.id.textTemperatura); //pegar valor
        SharedPreferences sh = getSharedPreferences("temperatura",MODE_PRIVATE); //"TEMEPRATURA" E O NOME , N O ID
        sh.edit().putString("temperatura", textTemperatura.getText().toString()).apply();

        double number = Double.parseDouble(textTemperatura.getText().toString());

        String retorno ="";

        if (number <=35.0){

            retorno = "A temperatura esta muito baixa!";

        } else if (number >=36.0 && number <=36.9){
            retorno = "A temperatura está controlada!";

        } else if (number >=37.0 && number <=37.8){
            retorno = "A temperatura deve ser observada!";

        } else if (number >= 38.0){
            retorno = " Necessário aplicar o medicamento!";

        }

        Intent intent = new Intent(this, Resultado.class); //intent joga as coisas um do lado pro outro (brinks , serve para jogar para outra tela)
        intent.putExtra("retorno", retorno);
        startActivity(intent);


        Toast.makeText(this, "enviando a mensagem", Toast.LENGTH_SHORT).show();

    }
}
