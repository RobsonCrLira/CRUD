package com.example.robso.crud;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaAluno extends AppCompatActivity {

    private DAO dao;
    private ListView listView;
    private List<Aluno> alunos;
    private Aluno aluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        listView = findViewById(R.id.listaalunos);
        dao = new DAO(this);

        alunos = dao.listaAlunos();

        ArrayAdapter<Aluno> adapter;
        adapter = new ArrayAdapter<Aluno>(this,android.R.layout.simple_list_item_1,alunos);
        listView.setAdapter(adapter);

    }

}
