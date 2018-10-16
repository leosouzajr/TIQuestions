package com.example.leona.tiquestions.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.leona.tiquestions.R;
import com.example.leona.tiquestions.entities.Pergunta;

public class PerguntaViewHolder extends RecyclerView.ViewHolder {
    private TextView tv_cod,tv_foiSorteada;
    public PerguntaViewHolder(View itemView) {
        super(itemView);
        this.tv_cod=(TextView) itemView.findViewById(R.id.tv_cod);
        this.tv_foiSorteada=(TextView) itemView.findViewById(R.id.tv_foiSorteada);
    }
    public void preencherDado(Pergunta pergunta){
        this.tv_cod.setText(pergunta.getCodPergunta());
        this.tv_foiSorteada.setText(pergunta.getFoiSorteada());
    }
}
