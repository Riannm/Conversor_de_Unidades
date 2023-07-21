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

public class Kilo extends AppCompatActivity {

    EditText valor;
    TextView resultado;
    TextView textView;
    final String[] options = {
            "Quilogramas para Gramas",
            "Quilogramas para Miligramas",
            "Gramas para Quilogramas",
            "Gramas para Miligramas",
            "Miligramas para Quilogramas ",
            "Miligramas para Grama",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

        valor = (EditText) findViewById(R.id.valorUser);
        resultado = (TextView) findViewById(R.id.resultadoTxt);

        textView = findViewById(R.id.textView);
        textView.setText("Kilo");
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
                    double KG_G = (valorDouble * Math.pow(10, 3));
                    resultado.setText("O seu resultado em Gramas é de: " + Math.round(KG_G));
                } else if (options[i].equals(options[1])) {
                    double KG_MG = (valorDouble * Math.pow(10, 6));
                    resultado.setText("O seu resultado em Miligrama é de: " + Math.round(KG_MG));
                } else if (options[i].equals(options[2])) {
                    double G_KG = (valorDouble / Math.pow(10, 3));
                    resultado.setText("O seu resultado em Quilograma é de: " + Math.round(G_KG));
                } else if (options[i].equals(options[3])) {
                    double G_MG = (valorDouble * 10);
                    resultado.setText("O seu resultado em Miligrama é de: " + Math.round(G_MG));
                } else if (options[i].equals(options[4])) {
                    double MG_KG = (valorDouble / Math.pow(10, 6));
                    resultado.setText("O seu resultado em Quilograma é de: " + Math.round(MG_KG));
                } else if (options[i].equals(options[5])) {
                    double MG_G = (valorDouble / Math.pow(10, 3));
                    resultado.setText("O seu resultado em Gramas é de: " + Math.round(MG_G));
                }
            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}