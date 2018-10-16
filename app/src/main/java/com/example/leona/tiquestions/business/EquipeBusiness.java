package com.example.leona.tiquestions.business;

import android.content.Context;

import com.example.leona.tiquestions.constants.DataBaseConstants;
import com.example.leona.tiquestions.entities.Equipe;
import com.example.leona.tiquestions.repository.EquipeRepositorio;

public class EquipeBusiness {
    private EquipeRepositorio mPerguntaRepositorio;

    public EquipeBusiness(Context context) {
        this.mPerguntaRepositorio = EquipeRepositorio.getInstance(context);

    }
    public int obterPontosEquipe(int idEquipe){
        int pontos= this.mPerguntaRepositorio.obterPontosEquipe("select * from "+
                DataBaseConstants.EQUIPE.NOME_TABELA+" where "+
                DataBaseConstants.EQUIPE.COLUNAS.IDEQUIPE+ "="+idEquipe+";");
        return pontos;
    }
    public boolean updatePontosEquipe(Equipe equipe){
        boolean atualizou=false;

        return atualizou;
    }
    public boolean insert(String nome)
    {
        return this.mPerguntaRepositorio.insert(nome);
    }
}
