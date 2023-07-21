package com.example.conversordeunidades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Temperatura extends AppCompatActivity {

    EditText valor;
    TextView resultado;
    TextView textView;
    final String[] options = {
            "Celsius para Fahrenheit",
            "Celsius para Kelvin",
            "Fahrenheit para Celsius",
            "Fahrenheit para Kelvin",
            "Kelvin para Celsius",
            "Kelvin para Fahrenheit",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

        valor = (EditText) findViewById(R.id.valorUser);
        resultado = (TextView) findViewById(R.id.resultadoTxt);

        textView = findViewById(R.id.textView);
        textView.setText("Temperatura");
    }

    public void voltar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void showChoices(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escolha uma opção");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String valorTxt = valor.getText().toString();
                double valorDouble = Double.parseDouble(valorTxt);

                if (options[i].equals(options[0])) {
                    double C_F = (valorDouble * 1.8) + 32;
                    resultado.setText("O seu resultado em Fahrenheit é de: " + Math.round(C_F));
                } else if (options[i].equals(options[1])) {
                    double C_K = valorDouble + 273;
                    resultado.setText("O seu resultado em Kelvin é de: " + Math.round(C_K));
                } else if (options[i].equals(options[2])) {
                    double F_C = (valorDouble - 32) / 1.8;
                    resultado.setText("O seu resultado em Celsius é de: " + Math.round(F_C));
                } else if (options[i].equals(options[3])) {
                    double F_K = ((valorDouble - 32) * 5 / 9) + 273;
                    resultado.setText("O seu resultado em Kelvin é de: " + Math.round(F_K));
                } else if (options[i].equals(options[4])) {
                    double K_C = valorDouble - 273;
                    resultado.setText("O seu resultado em Celsius é de: " + Math.round(K_C));
                } else if (options[i].equals(options[5])) {
                    double K_F = (valorDouble - 273) * 1.8 + 32;
                    resultado.setText("O seu resultado em Fahrenheit é de: " + Math.round(K_F));
                }
            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}