package com.example.robso.crud;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    private ConectaBanco conectaBanco;
    private SQLiteDatabase banco;

    public DAO(Context context){
        conectaBanco = new ConectaBanco(context);
        banco = conectaBanco.getWritableDatabase();
    }

    public long inserir(Aluno aluno){
        long res;
        ContentValues values = new ContentValues();
        values.put(ConectaBanco.Alunos.NOME, aluno.getNome());
        values.put(ConectaBanco.Alunos.SOBRENOME, aluno.getSobrenome());
        values.put(ConectaBanco.Alunos.IDADE, aluno.getIdade());
        values.put(ConectaBanco.Alunos.CURSO,aluno.getCurso());
        res = banco.insert(ConectaBanco.Alunos.TABELA,null,values);
        banco.close();
        return res;

    }

    public List<Aluno> listaAlunos(){
        List<Aluno> alunos = new ArrayList<Aluno>();
        Cursor cursor = banco.query(ConectaBanco.Alunos.TABELA, ConectaBanco.Alunos.COLUNAS,
                null,null,null,null,null);
        while (cursor.moveToNext()){
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setSobrenome(cursor.getString(2));
            a.setIdade(cursor.getInt(3));
            a.setCurso(cursor.getString(4));
            alunos.add(a);
        }
        banco.close();
        return alunos;
    }

    public Aluno consulta(int id){
        Aluno a = new Aluno();
        Cursor cursor;
        String where = ConectaBanco.Alunos._ID+"="+id;
        cursor =  banco.query(ConectaBanco.Alunos.TABELA,ConectaBanco.Alunos.COLUNAS,where,
                null,null,null,null);

        cursor.moveToFirst();
        a.setId(cursor.getInt(0));
        a.setNome(cursor.getString(1));
        a.setSobrenome(cursor.getString(2));
        a.setIdade(cursor.getInt(3));
        a.setCurso(cursor.getString(4));

        banco.close();
        return a;
    }

    public void excluir(int id){
        String where = ConectaBanco.Alunos._ID+"="+id;
        banco.delete(ConectaBanco.Alunos.TABELA,where,null);
        banco.close();
    }

    public void atualizar(Aluno aluno){
        String where = ConectaBanco.Alunos._ID+"="+aluno.getId();

        ContentValues values = new ContentValues();
        values.put(ConectaBanco.Alunos.NOME, aluno.getNome());
        values.put(ConectaBanco.Alunos.SOBRENOME, aluno.getSobrenome());
        values.put(ConectaBanco.Alunos.IDADE, aluno.getIdade());
        values.put(ConectaBanco.Alunos.CURSO,aluno.getCurso());

        banco.update(ConectaBanco.Alunos.TABELA, values, where, null);
        banco.close();
    }


}
