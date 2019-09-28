package com.example.robso.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConectaBanco extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "cadastro" ;
    private static int VERSAO = 1;

    public static class Alunos{
        public static final String TABELA = "aluno";
        public static final String _ID = "id";
        public static final String NOME = "nome";
        public static final String SOBRENOME =  "sobrenome";
        public static final String IDADE = "idade";
        public static final String CURSO = "curso";

        public static final String[] COLUNAS = new String[]{ _ID,NOME,SOBRENOME,IDADE, CURSO};
    }

    public ConectaBanco(Context context){
        super(context, BANCO_DADOS,null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE aluno(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "sobrenome TEXT, " +
                "idade INTEGER, " +
                "curso TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
