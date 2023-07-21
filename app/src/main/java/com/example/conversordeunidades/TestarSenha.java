package com.example.conversordeunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TestarSenha extends AppCompatActivity {

    EditText senhaInputUser;
    TextView resultadoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testar_senha);

        senhaInputUser = findViewById(R.id.senhaInputUser);
        resultadoSenha = findViewById(R.id.resultadoSenha);

    }

    public void voltar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void testarSenha(View view) {

        String especial_caracteres = "[!@#$%&*()_+=|<>?{}\\[\\]~0123456789-]";

        String senha = String.valueOf(senhaInputUser.getText());

        if (!senha.isEmpty()) {

            if (senha.length() >= 10 && senha.matches(".*" + especial_caracteres + ".*")) {
                String fullText = "Senha <font color='#14B82F'>forte</font>";
                resultadoSenha.setText(Html.fromHtml(fullText));
            } else if (senha.length() >= 8 && senha.length() < 10 && senha.matches(".*" + especial_caracteres + ".*")) {
                String fullText = "Senha <font color='#E8D50E'>média</font>";
                resultadoSenha.setText(Html.fromHtml(fullText));
            } else if (senha.length() < 8 || !senha.matches(".*" + especial_caracteres + ".*")) {
                String fullText = "Senha <font color='#A4212F'>fraca</font>";
                resultadoSenha.setText(Html.fromHtml(fullText));
            }
        } else {
            resultadoSenha.setText("Por favor insira uma senha!");
        }
    }

}