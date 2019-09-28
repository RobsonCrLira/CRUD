package com.example.robso.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CadAluno extends AppCompatActivity {

    private EditText codigo;
    private EditText nome;
    private EditText sobrenome;
    private EditText idade;
    private Spinner cursos;
    private DAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_aluno);

        codigo = (EditText) findViewById(R.id.codigo);
        nome = (EditText) findViewById(R.id.nome);
        sobrenome = (EditText) findViewById(R.id.sobrenome);
        idade = (EditText) findViewById(R.id.idade);

        //Declaração para carregar e aparecer os dados do Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cursos_nome, android.R.layout.simple_spinner_item);
        cursos = (Spinner) findViewById(R.id.cursos);
        cursos.setAdapter(adapter);

        dao = new DAO(this);
    }

    public void salvar(View v){
        Aluno a = new Aluno();
        a.setId(Integer.parseInt(codigo.getText().toString()));
        a.setNome(nome.getText().toString());
        a.setSobrenome(nome.getText().toString());
        a.setIdade(Integer.parseInt(idade.getText().toString()));
        a.setCurso(cursos.getSelectedItem().toString());

        if (a.getId()>0){
            dao.atualizar(a);

            Toast.makeText(this,"Aluno Atualizado",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,MainActivity.class));


        }else {
            long resultado =  dao.inserir(a);

            if(resultado !=-1){
                Toast.makeText(this, getString(R.string.registro_salvo)+"\n Codigo : "+resultado,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,MainActivity.class));
            }else{
                Toast.makeText(this, getString(R.string.erro_salvar),Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void deletar(View v){
        Aluno aluno = new Aluno();
        aluno.setId(Integer.parseInt(codigo.getText().toString()));
        dao.excluir(aluno.getId());

        Toast.makeText(this, "Aluno Deletado",Toast.LENGTH_LONG).show();
    }

    public void editar(View v){
        Aluno aluno = new Aluno();
        aluno.setId(Integer.parseInt(codigo.getText().toString()));

        aluno = dao.consulta(aluno.getId());

        nome.setText(aluno.getNome());
        sobrenome.setText(aluno.getSobrenome());
        idade.setText(aluno.getIdade());
    }

}
