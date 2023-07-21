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

public class VelKM_MS extends AppCompatActivity {

    EditText valor;
    TextView resultado;
    TextView textView;
    final String[] options = {
            "Kilometros/hora para Metros/segundo",
            "Metros/segundo para Kilometros/hora",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

        valor = findViewById(R.id.valorUser);
        resultado = findViewById(R.id.resultadoTxt);

        textView = findViewById(R.id.textView);
        textView.setText("Velocidade");
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
                    double KM_MS = (valorDouble / 3.6);
                    resultado.setText("O seu resultado em Metros por Segundo é de: " + Math.round(KM_MS));
                } else if (options[i].equals(options[1])) {
                    double MS_KM = (valorDouble * 3.6);
                    resultado.setText("O seu resultado em Quilometros por Hora é de: " + Math.round(MS_KM));
                }
            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}