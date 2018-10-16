package com.example.leona.tiquestions.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.leona.tiquestions.constants.DataBaseConstants;
import com.example.leona.tiquestions.entities.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntaRepositorio {
    private static PerguntaRepositorio INSTANCE;
    private DataBaseHelper mTIDBHelper;

    private PerguntaRepositorio(Context context) {
        this.mTIDBHelper = new DataBaseHelper(context);
    }

    public static synchronized PerguntaRepositorio getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new PerguntaRepositorio(context);
        }
        return INSTANCE;
    }

    public boolean insert(Pergunta pergunta) {
        boolean sucessoNaInsercao = false;
        try {
            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.IDPERGUNTA, pergunta.getIdPergunta());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.CODPERGUNTA, pergunta.getCodPergunta());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ENUNCIADO, pergunta.getEnunciado());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.TIPO, pergunta.getTipo());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMA, pergunta.getItemA());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMB, pergunta.getItemB());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMC, pergunta.getItemC());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMD, pergunta.getItemD());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.RESPOSTASUBJETIVA, pergunta.getRespostaSubjetiva());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMCORRETO, pergunta.getItemCorreto());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.NIVEL, pergunta.getNivel());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.PONTOSPERGUNTA, pergunta.getPontosPergunta());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.AREA, pergunta.getArea());
            contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.FOISORTEADA, pergunta.getFoiSorteada());


            long resposta = sqLiteDatabase.insert(DataBaseConstants.PERGUNTAS.NOME_TABELA, null, contentValues);
            if (resposta != -1) {
                sucessoNaInsercao = true;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());

            return sucessoNaInsercao;
        }
        return sucessoNaInsercao;
    }

    public List<Pergunta> consultarPerguntas(String query) {
        List<Pergunta> listaPeguntas = new ArrayList<>();

        try {
            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    Pergunta pergunta = new Pergunta();
                    pergunta.setIdPergunta(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.IDPERGUNTA)));
                    pergunta.setArea(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.AREA)));
                    pergunta.setCodPergunta(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.CODPERGUNTA)));
                    pergunta.setEnunciado(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ENUNCIADO)));
                    pergunta.setItemA(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMA)));
                    pergunta.setItemB(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMB)));
                    pergunta.setItemC(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMC)));
                    pergunta.setItemD(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMD)));
                    pergunta.setRespostaSubjetiva(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.RESPOSTASUBJETIVA)));
                    pergunta.setItemCorreto(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMCORRETO)));
                    pergunta.setNivel(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.NIVEL)));
                    pergunta.setPontosPergunta(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.PONTOSPERGUNTA)));
                    pergunta.setTipo(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.TIPO)));
                    pergunta.setFoiSorteada(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.FOISORTEADA)));
                    listaPeguntas.add(pergunta);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            return listaPeguntas;
        }
        return listaPeguntas;

    }
    public Pergunta consultarPerguntaPorCodigo(String query) {
        Pergunta pergunta = new Pergunta();

        try {
            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {

                    pergunta.setIdPergunta(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.IDPERGUNTA)));
                    pergunta.setArea(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.AREA)));
                    pergunta.setCodPergunta(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.CODPERGUNTA)));
                    pergunta.setEnunciado(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ENUNCIADO)));
                    pergunta.setItemA(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMA)));
                    pergunta.setItemB(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMB)));
                    pergunta.setItemC(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMC)));
                    pergunta.setItemD(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMD)));
                    pergunta.setRespostaSubjetiva(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.RESPOSTASUBJETIVA)));
                    pergunta.setItemCorreto(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMCORRETO)));
                    pergunta.setNivel(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.NIVEL)));
                    pergunta.setPontosPergunta(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.PONTOSPERGUNTA)));
                    pergunta.setTipo(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.TIPO)));
                    pergunta.setFoiSorteada(cursor.getString(cursor.getColumnIndex(DataBaseConstants.PERGUNTAS.COLUNAS.FOISORTEADA)));

                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            return pergunta;
        }
        return pergunta;

    }

    public boolean update() {
        boolean sucessoNaInsercao = false;
        try {
            String sqlQuery="update "+DataBaseConstants.PERGUNTAS.NOME_TABELA+ " set "+
                    DataBaseConstants.PERGUNTAS.COLUNAS.FOISORTEADA+ "='não';";

            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getWritableDatabase();
            sqLiteDatabase.execSQL(sqlQuery);
            sucessoNaInsercao=true;

        } catch (Exception e) {
            System.out.print(e.getMessage());

            return sucessoNaInsercao;
        }
        return sucessoNaInsercao;
    }

    public boolean updatePerguntaSorteada(Pergunta pergunta) {

        try{
            SQLiteDatabase sqLiteDatabase = this.mTIDBHelper.getWritableDatabase();

        String clausulaWhere = DataBaseConstants.PERGUNTAS.COLUNAS.IDPERGUNTA + "= ?";
        String[] argumentosWhere = {String.valueOf(pergunta.getIdPergunta())};
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.IDPERGUNTA, pergunta.getIdPergunta());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.CODPERGUNTA, pergunta.getCodPergunta());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ENUNCIADO, pergunta.getEnunciado());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.TIPO, pergunta.getTipo());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMA, pergunta.getItemA());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMB, pergunta.getItemB());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMC, pergunta.getItemC());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMD, pergunta.getItemD());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.RESPOSTASUBJETIVA, pergunta.getRespostaSubjetiva());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.ITEMCORRETO, pergunta.getItemCorreto());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.NIVEL, pergunta.getNivel());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.PONTOSPERGUNTA, pergunta.getPontosPergunta());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.AREA, pergunta.getArea());
        contentValues.put(DataBaseConstants.PERGUNTAS.COLUNAS.FOISORTEADA, "sim");
        sqLiteDatabase.update(DataBaseConstants.PERGUNTAS.NOME_TABELA, contentValues, clausulaWhere, argumentosWhere);
        return true;
        } catch (Exception e) {
            return false;
        }
    }
}
