package com.example.leona.tiquestions.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.leona.tiquestions.R;
import com.example.leona.tiquestions.business.PerguntaBusiness;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static ViewHolder mViewHolder = new ViewHolder();
    private PerguntaBusiness perguntaBusiness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        this.mViewHolder.btnCompetir = (Button) findViewById(R.id.btn_competir);
        this.setListeners();
        perguntaBusiness= new PerguntaBusiness(this);
    }

    private void setListeners() {
        this.mViewHolder.btnCompetir.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if(menuItem.getItemId()==R.id.act_cadastro_equipe){

        }else if(menuItem.getItemId()==R.id.act_cadastro_pergunta){
            startActivity(new Intent(this, TelaCadastroPerguntasActivity.class));
        }else if(menuItem.getItemId()==R.id.act_reiniciar_sorteio){
            perguntaBusiness.updateReiniciarSorteio();
            Toast.makeText(this,"Sorteio de perguntas reiniciado!",Toast.LENGTH_SHORT).show();
        }else if(menuItem.getItemId()==R.id.act_ver_perguntas){
            startActivity(new Intent(this, ListaTodasAsPerguntasActivity.class));
        }

        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_competir) {
            startActivity(new Intent(this, TelaPerguntaActivity.class));
        }
    }

    private static class ViewHolder {
        Button btnCompetir;
    }
}
