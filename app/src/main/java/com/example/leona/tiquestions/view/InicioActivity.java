package com.example.leona.tiquestions.view;

import com.example.leona.tiquestions.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Button b1 = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            startActivity(new Intent(this, TelaCadastroPerguntasActivity.class));
        }else   if(view.getId()==R.id.button3){
            startActivity(new Intent(this, ListaTodasAsPerguntasActivity.class));
        }else{
            startActivity(new Intent(this, TelaPerguntaActivity.class));

        }
    }
}
