package com.example.leona.tiquestions.business;

import android.content.Context;
import android.provider.ContactsContract;

import com.example.leona.tiquestions.constants.DataBaseConstants;
import com.example.leona.tiquestions.entities.Pergunta;
import com.example.leona.tiquestions.repository.PerguntaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class PerguntaBusiness {
    private PerguntaRepositorio mPerguntaRepositorio;

    public PerguntaBusiness(Context context) {
        this.mPerguntaRepositorio = PerguntaRepositorio.getInstance(context);

    }

    public boolean insert(Pergunta pergunta) {
        return this.mPerguntaRepositorio.insert(pergunta);
    }

    public List<Pergunta> consultarPerguntas() {
        return this.mPerguntaRepositorio.consultarPerguntas("select * from "+ DataBaseConstants.PERGUNTAS.NOME_TABELA+";");
    }
    public boolean updateReiniciarSorteio() {
        return this.mPerguntaRepositorio.update();
    }
    public boolean updatePerguntaSorteada(Pergunta pergunta) {
        return this.mPerguntaRepositorio.updatePerguntaSorteada(pergunta);
    }
    public Pergunta consultarPerguntaPorCodigo(String codigo) {
        return this.mPerguntaRepositorio.consultarPerguntaPorCodigo("select * from "+
                DataBaseConstants.PERGUNTAS.NOME_TABELA+" where "+
                DataBaseConstants.PERGUNTAS.COLUNAS.CODPERGUNTA+ "='"+codigo+"' and "+DataBaseConstants.PERGUNTAS.COLUNAS.FOISORTEADA+"='não';");
    }
}
