package com.example.leona.tiquestions.util;

import android.content.Context;
import android.content.SharedPreferences;

public class DadosLocais {
    private final SharedPreferences mDados;

    public DadosLocais(Context contexto){
        this.mDados= contexto.getSharedPreferences("TIQuestions", Context.MODE_PRIVATE);
    }
    public void inserirIdAtual(String chave, int valor){
        this.mDados.edit().putInt(chave,valor).apply();
    }
    public int pegarIdAtual(String chave){
        return  this.mDados.getInt(chave, 0);
    }
    public void inserirM1Atual(String chave, int valor){
        this.mDados.edit().putInt(chave,valor).apply();
    }
    public int pegarM1Atual(String chave){
        return  this.mDados.getInt(chave, 0);
    }
    public void inserirM2Atual(String chave, int valor){
        this.mDados.edit().putInt(chave,valor).apply();
    }
    public int pegarM2Atual(String chave){
        return  this.mDados.getInt(chave, 0);
    }
}
