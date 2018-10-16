package com.example.leona.tiquestions.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leona.tiquestions.R;
import com.example.leona.tiquestions.entities.Pergunta;
import com.example.leona.tiquestions.viewHolders.PerguntaViewHolder;

import java.util.List;

public class PerguntaAdapter extends RecyclerView.Adapter<PerguntaViewHolder> {
private List<Pergunta> listaPergunta;

    public PerguntaAdapter(List<Pergunta> listaPergunta) {
        this.listaPergunta = listaPergunta;
    }

    @NonNull
    @Override
    public PerguntaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View viewperguntas;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        viewperguntas=layoutInflater.inflate(R.layout.row_list_perguntas,parent,false);

        return new PerguntaViewHolder(viewperguntas);
    }

    @Override
    public void onBindViewHolder(@NonNull PerguntaViewHolder holder, int position) {
        Pergunta pergunta = this.listaPergunta.get(position);
        holder.preencherDado(pergunta);
    }

    @Override
    public int getItemCount() {
        return this.listaPergunta.size();
    }
}
