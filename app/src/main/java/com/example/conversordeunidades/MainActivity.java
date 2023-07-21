package com.example.conversordeunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ImageButton Comprimento;
    ImageButton Litro;
    ImageButton Temperatura;
    ImageButton Tempo;
    ImageButton Massa;
    ImageButton Vel;
    ImageButton Gerar_Senha;
    ImageButton Testar_Senha;
    FirebaseAuth auth;
    FirebaseUser user;
    ImageButton logOff;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Comprimento = findViewById(R.id.Unidade_de_Comprimento);
        Litro = findViewById(R.id.Unidade_de_Litro);
        Temperatura = findViewById(R.id.Unidade_de_Temperatura);
        Tempo = findViewById(R.id.Unidade_de_Tempo);
        Massa = findViewById(R.id.Unidade_de_Massa);
        Gerar_Senha = findViewById(R.id.Gerador_de_Senhas);
        Testar_Senha = findViewById(R.id.Testador_de_Senhas);
        Vel = findViewById(R.id.Velocidade_Conversor);
        logOff = findViewById(R.id.voltar);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        logOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void voltar(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }


    public void Entrar_Gerar_Senha(View view) {

        Intent intent = new Intent(getApplicationContext(), GerarSenha.class);
        startActivity(intent);
        finish();

    }

    public void Entrar_Velocidade(View view) {

        Intent intent = new Intent(getApplicationContext(), VelKM_MS.class);
        startActivity(intent);
        finish();

    }

    public void Entrar_Testar_Senha(View view) {

        Intent intent = new Intent(getApplicationContext(), TestarSenha.class);
        startActivity(intent);
        finish();

    }

    public void Entrar_Comprimento(View view) {

        Intent intent = new Intent(getApplicationContext(), Comprimento.class);
        startActivity(intent);
        finish();

    }

    public void Entrar_Tempo(View view) {

        Intent intent = new Intent(getApplicationContext(), Tempo.class);
        startActivity(intent);
        finish();

    }

    public void Entrar_Massa(View view) {

        Intent intent = new Intent(getApplicationContext(), Kilo.class);
        startActivity(intent);
        finish();

    }

    public void Entrar_Litro(View view) {

        Intent intent = new Intent(getApplicationContext(), Litro.class);
        startActivity(intent);
        finish();

    }

    public void Entrar_Temperatura(View view) {

        Intent intent = new Intent(getApplicationContext(), Temperatura.class);
        startActivity(intent);
        finish();

    }

}