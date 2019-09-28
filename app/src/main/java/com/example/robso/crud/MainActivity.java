package com.example.robso.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void selecionarOpcao(View view) {
        switch (view.getId()) {
            case R.id.adicionar_alunos:
                startActivity(new Intent(this, CadAluno.class));
                break;

            case R.id.tv_lista_alunos:
                startActivity(new Intent(this, ListaAluno.class));
                break;
        }
    }
}
