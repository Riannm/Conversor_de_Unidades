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

public class Comprimento extends AppCompatActivity {

    EditText valor;
    TextView resultado;
    TextView textView;
    final String[] options = {
            "Quilômetro para Metros",
            "Quilômetro para Centímetros",
            "Quilômetro para Milímetros",
            "Metros para Quilômetro",
            "Metros para Centímetros",
            "Metros para Milímetros",
            "Milímetros  para Quilômetro",
            "Milímetros  para Metro",
            "Milímetros  para Centímetro",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimento);

        valor = (EditText) findViewById(R.id.valorUser);
        resultado = (TextView) findViewById(R.id.resultadoTxt);

        textView = findViewById(R.id.textView);
        textView.setText("Comprimento");
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

                if (options[i].equals(options[0])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double KM_M = Math.pow(valorDouble * 10, 3);
                        resultado.setText("O seu resultado em Metros é de: " + KM_M);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double KM_M = Math.pow(valorInt * 10, 3);
                        resultado.setText("O seu resultado em Metros é de: " + KM_M);
                    }
                } else if (options[i].equals(options[1])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double KM_CM = Math.pow(valorDouble * 10, 5);
                        resultado.setText("O seu resultado em Centímetros é de: " + KM_CM);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double KM_CM = Math.pow(valorInt * 10, 5);
                        resultado.setText("O seu resultado em Centímetros é de: " + KM_CM);
                    }
                } else if (options[i].equals(options[2])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double KM_MM = Math.pow(valorDouble * 10, 6);
                        resultado.setText("O seu resultado em Milímetros é de: " + KM_MM);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double KM_MM = Math.pow(valorInt * 10, 6);
                        resultado.setText("O seu resultado em Metros é de: " + KM_MM);
                    }
                } else if (options[i].equals(options[3])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double M_KM = Math.pow(valorDouble * 10, 3);
                        resultado.setText("O seu resultado em Quilômetro é de: " + M_KM);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double M_KM = Math.pow(valorInt * 10, 3);
                        resultado.setText("O seu resultado em Quilômetro é de: " + M_KM);
                    }
                } else if (options[i].equals(options[4])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double M_CM = Math.pow(valorDouble * 10, 2);
                        resultado.setText("O seu resultado em Centímetros é de: " + M_CM);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double M_CM = Math.pow(valorInt * 10, 2);
                        resultado.setText("O seu resultado em Centímetros é de: " + M_CM);
                    }
                } else if (options[i].equals(options[5])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double M_MM = Math.pow(valorDouble * 10, 10);
                        resultado.setText("O seu resultado em Milímetros é de: " + M_MM);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double M_MM = Math.pow(valorInt * 10, 10);
                        resultado.setText("O seu resultado em Milímetros é de: " + M_MM);
                    }
                } else if (options[i].equals(options[6])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double MM_KM = Math.pow(valorDouble / 10, 6);
                        resultado.setText("O seu resultado em Quilômetro é de: " + MM_KM);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double MM_KM = Math.pow(valorInt / 10, 6);
                        resultado.setText("O seu resultado em Quilômetro é de: " + MM_KM);
                    }
                } else if (options[i].equals(options[7])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double MM_M = Math.pow(valorDouble / 10, 3);
                        resultado.setText("O seu resultado em Metros é de: " + MM_M);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        double MM_M = Math.pow(valorInt / 10, 3);
                        resultado.setText("O seu resutado em Metros é de: " + MM_M);
                    }
                } else if (options[i].equals(options[8])) {
                    try {
                        double valorDouble = Double.parseDouble(valorTxt);
                        double MM_CM = (valorDouble / 10);
                        resultado.setText("O seu resultado em Centímetros é de: " + MM_CM);
                    } catch (Exception e) {
                        int valorInt = Integer.parseInt(valorTxt);
                        int MM_CM = (valorInt / 10);
                        resultado.setText("O seu resultado em Centímetros é de: " + MM_CM);
                    }
                }
            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}