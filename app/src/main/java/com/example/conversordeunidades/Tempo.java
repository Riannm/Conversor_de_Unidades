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

public class Tempo extends AppCompatActivity {
    EditText valor;
    TextView resultado;
    TextView textView;
    final String[] options = {
            "Horas para Minutos",
            "Horas para Segundos",
            "Minutos para Horas",
            "Minutos para Segundos",
            "Segundos para Horas",
            "Segundos para Minutos",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

        valor = (EditText) findViewById(R.id.valorUser);
        resultado = (TextView) findViewById(R.id.resultadoTxt);

        textView = findViewById(R.id.textView);
        textView.setText("Tempo");
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
                    double HO_MIN = (valorDouble * 60);
                    resultado.setText("O seu resultado em Minutos é de: " + Math.round(HO_MIN));
                } else if (options[i].equals(options[1])) {
                    double HO_SEC = (valorDouble * (Math.pow(60, 2)));
                    resultado.setText("O seu resultado em Segundos é de: " + Math.round(HO_SEC));
                } else if (options[i].equals(options[2])) {
                    double MIN_HO = (valorDouble / 60);
                    resultado.setText("O seu resultado em Horas é de: " + Math.round(MIN_HO));
                } else if (options[i].equals(options[3])) {
                    double MIN_SEC = (valorDouble * 60);
                    resultado.setText("O seu resultado em Segundos é de: " + Math.round(MIN_SEC));
                } else if (options[i].equals(options[4])) {
                    double SEC_HO = (valorDouble / (Math.pow(60, 2)));
                    resultado.setText("O seu resultado em Horas é de: " + Math.round(SEC_HO));
                } else if (options[i].equals(options[5])) {
                    double SEC_MIN = (valorDouble / 60);
                    resultado.setText("O seu resultado em Minutos é de: " + Math.round(SEC_MIN));
                }
            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}