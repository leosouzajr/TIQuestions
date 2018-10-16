package com.example.leona.tiquestions.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.leona.tiquestions.constants.DataBaseConstants;
import com.example.leona.tiquestions.entities.Equipe;


public class EquipeRepositorio {
    private static EquipeRepositorio INSTANCE;
    private DataBaseHelper mTIDBHelper;
    private EquipeRepositorio(Context context) {
        this.mTIDBHelper = new DataBaseHelper(context);
    }

    public static synchronized EquipeRepositorio getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new EquipeRepositorio(context);
        }
        return INSTANCE;
    }
    public boolean insert(String nomeEquqipe) {
        boolean sucessoNaInsercao = false;
        try {
            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DataBaseConstants.EQUIPE.COLUNAS.NOMEEQUIPE, nomeEquqipe);
            contentValues.put(DataBaseConstants.EQUIPE.COLUNAS.PONTOSEQUIPE, 0);




            long resposta = sqLiteDatabase.insert(DataBaseConstants.EQUIPE.NOME_TABELA, null, contentValues);
            if (resposta != -1) {
                sucessoNaInsercao = true;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());

            return sucessoNaInsercao;
        }
        return sucessoNaInsercao;
    }
    public int obterPontosEquipe(String query){
        int pontos=0;
        try {
            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    pontos = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.EQUIPE.COLUNAS.PONTOSEQUIPE));
                }
            }

        }  catch (Exception e) {

        }
        return pontos;
    }
    public boolean updatePontosEquipe(Equipe equipe) {
       boolean sucessoNaInsercao=false;
        try {
            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getWritableDatabase();
            String clausulaWhere = DataBaseConstants.EQUIPE.COLUNAS.IDEQUIPE + "= ?";
            String[] argumentosWhere = {String.valueOf(equipe.getIdEquipe())};
            ContentValues contentValues = new ContentValues();
            contentValues.put(DataBaseConstants.EQUIPE.COLUNAS.IDEQUIPE, equipe.getIdEquipe());
            contentValues.put(DataBaseConstants.EQUIPE.COLUNAS.NOMEEQUIPE, equipe.getNomeEquipe());
            contentValues.put(DataBaseConstants.EQUIPE.COLUNAS.PONTOSEQUIPE, equipe.getPontosEquipe());
            sqLiteDatabase.update(DataBaseConstants.EQUIPE.NOME_TABELA, contentValues, clausulaWhere, argumentosWhere);


            sucessoNaInsercao = true;

        } catch (Exception e) {
            System.out.print(e.getMessage());

        }
        return sucessoNaInsercao;
    }
}
