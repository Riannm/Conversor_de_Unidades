package com.example.conversordeunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GerarSenha extends AppCompatActivity {

    EditText lerTamanho2;
    TextView senhaGerada;
    TextView textView2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_senha);

        lerTamanho2 = findViewById(R.id.lerTamanho2);
        senhaGerada = findViewById(R.id.senhaGerada);

        textView2 = findViewById(R.id.textView2);

    }

    public void voltar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void gerarSenha(View view) {

        Random random = new Random();
        StringBuilder stringbuilder = new StringBuilder();
        int i;

        String tamanhoSenha = lerTamanho2.getText().toString();

        if (!tamanhoSenha.isEmpty()) {

            textView2.setText("A senha gerada é: ");

            int tamanhoSenhaInt = Integer.parseInt(tamanhoSenha);

            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"#$%&'()*+,-./:;?@[\\]~";

            stringbuilder.setLength(0); // Clear the String Builder

            for (i = 0; i < tamanhoSenhaInt; i++) {
                int IndexRandomico = random.nextInt(caracteres.length());
                char randomChar = caracteres.charAt(IndexRandomico);
                stringbuilder.append(randomChar);
            }

            String senhaRandom = stringbuilder.toString();
            senhaGerada.setText(senhaRandom);
        } else {
            textView2.setText("Por favor insira o tamanho: ");
        }
    }
}
