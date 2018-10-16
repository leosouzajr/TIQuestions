package com.example.leona.tiquestions.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.leona.tiquestions.constants.ConstantsApp;
import com.example.leona.tiquestions.constants.DataBaseConstants;
import com.example.leona.tiquestions.util.DadosLocais;

public class DataBaseHelper  extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="TIQuestions.db";
    private static DadosLocais dadosLocais;
    private static final String SQL_CREATE_TABELA_PERGUNTA =

            "create table " + DataBaseConstants.PERGUNTAS.NOME_TABELA + " ("
                    + DataBaseConstants.PERGUNTAS.COLUNAS.IDPERGUNTA + " integer primary key, "
                    + DataBaseConstants.PERGUNTAS.COLUNAS.CODPERGUNTA + " text, "
                    + DataBaseConstants.PERGUNTAS.COLUNAS.ENUNCIADO + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.TIPO + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.ITEMA + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.ITEMB + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.ITEMC + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.ITEMD + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.RESPOSTASUBJETIVA + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.ITEMCORRETO + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.NIVEL + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.PONTOSPERGUNTA + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.AREA + " text,"
                    + DataBaseConstants.PERGUNTAS.COLUNAS.FOISORTEADA + " text );";

    private static final String SQL_DROP_TABELA_PERGUNTA= "drop table if exists " + DataBaseConstants.PERGUNTAS.NOME_TABELA +";";
    private static final String SQL_CREATE_TABELA_EQUIPE =
            "create table " + DataBaseConstants.EQUIPE.NOME_TABELA + " ("
                    + DataBaseConstants.EQUIPE.COLUNAS.IDEQUIPE+ " integer primary key AUTOINCREMENT , "
            + DataBaseConstants.EQUIPE.COLUNAS.NOMEEQUIPE + " text, "
                    + DataBaseConstants.EQUIPE.COLUNAS.PONTOSEQUIPE + " integer);";
    private static final String SQL_DROP_TABELA_EQUIPE= "drop table if exists " + DataBaseConstants.EQUIPE.NOME_TABELA +";";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABELA_PERGUNTA);
        sqLiteDatabase.execSQL(SQL_CREATE_TABELA_EQUIPE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABELA_PERGUNTA);
        sqLiteDatabase.execSQL(SQL_CREATE_TABELA_PERGUNTA);
        sqLiteDatabase.execSQL(SQL_DROP_TABELA_EQUIPE);
        sqLiteDatabase.execSQL(SQL_CREATE_TABELA_EQUIPE);

    }
}
