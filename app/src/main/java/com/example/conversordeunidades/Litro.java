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

public class Litro extends AppCompatActivity {

    EditText valor;
    TextView resultado;
    TextView textView;
    final String[] options = {
            "Quilolitro para Litro",
            "Quilolitro para Mililitro",
            "Litro para Quilolitro",
            "Litro para Mililitro",
            "Mililitro para Quilolitro",
            "Mililitro para Litro",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

        valor = (EditText) findViewById(R.id.valorUser);
        resultado = (TextView) findViewById(R.id.resultadoTxt);

        textView = findViewById(R.id.textView);
        textView.setText("Litro");
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
                    double KL_L = (valorDouble * Math.pow(10, 3));
                    resultado.setText("O seu resultado em Litro é de: " + Math.round(KL_L));
                } else if (options[i].equals(options[1])) {
                    double KL_ML = (valorDouble * Math.pow(10, 6));
                    resultado.setText("O seu resultado em Mililitro é de: " + Math.round(KL_ML));
                } else if (options[i].equals(options[2])) {
                    double L_KL = (valorDouble / Math.pow(10, 3));
                    resultado.setText("O seu resultado em Quilolitro é de: " + Math.round(L_KL));
                } else if (options[i].equals(options[3])) {
                    double L_ML = (valorDouble * 10);
                    resultado.setText("O seu resultado em Mililitro é de: " + Math.round(L_ML));
                } else if (options[i].equals(options[4])) {
                    double ML_KL = (valorDouble / Math.pow(10, 6));
                    resultado.setText("O seu resultado em Quilolitro é de: " + Math.round(ML_KL));
                } else if (options[i].equals(options[5])) {
                    double ML_L = (valorDouble / Math.pow(10, 3));
                    resultado.setText("O seu resultado em Litros é de: " + Math.round(ML_L));
                }
            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}