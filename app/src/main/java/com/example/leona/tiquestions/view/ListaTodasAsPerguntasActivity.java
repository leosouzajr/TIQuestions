package com.example.leona.tiquestions.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.leona.tiquestions.R;
import com.example.leona.tiquestions.adapter.PerguntaAdapter;
import com.example.leona.tiquestions.business.PerguntaBusiness;

public class ListaTodasAsPerguntasActivity extends AppCompatActivity {
    private static ViewHolder mViewHolder = new ViewHolder();
    private PerguntaBusiness perguntaBusiness;
    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_todas_as_perguntas);
        perguntaBusiness = new PerguntaBusiness(this);
        this.mViewHolder.recyclerPerguntas = (RecyclerView) findViewById(R.id.recycler_perguntas);

        this.mViewHolder.recyclerPerguntas.setLayoutManager(new LinearLayoutManager(this));
        PerguntaAdapter perguntaAdapter = new PerguntaAdapter(perguntaBusiness.consultarPerguntas());
        this.mViewHolder.recyclerPerguntas.setAdapter(perguntaAdapter);
        perguntaAdapter.notifyDataSetChanged();
    }
    private static class ViewHolder {

       RecyclerView recyclerPerguntas;
    }
}
