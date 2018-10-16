package com.example.leona.tiquestions.view;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leona.tiquestions.R;
import com.example.leona.tiquestions.business.EquipeBusiness;
import com.example.leona.tiquestions.business.PerguntaBusiness;
import com.example.leona.tiquestions.entities.Equipe;
import com.example.leona.tiquestions.entities.Pergunta;

public class TelaPerguntaActivity extends AppCompatActivity implements View.OnClickListener {
    private static ViewHolder mViewHolder = new ViewHolder();
    private PerguntaBusiness perguntaBusiness;
    private EquipeBusiness equipeBusiness;
    private static Equipe equipeAtual;
    Pergunta pergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pergunta);
        this.mViewHolder.tvEnunciado = (TextView) findViewById(R.id.tv_enunciado);
        this.mViewHolder.tvArea = (TextView) findViewById(R.id.tv_area);
        this.mViewHolder.tvPontosQuestao = (TextView) findViewById(R.id.tv_pontos_questao);
        this.mViewHolder.etCodigoPergunta = (EditText) findViewById(R.id.et_codigo_pergunta);
        this.mViewHolder.etRespostaSubjetiva = (EditText) findViewById(R.id.et_resposta_subjetiva);
        this.mViewHolder.ivConsultar = (ImageView) findViewById(R.id.iv_consultar);
        this.mViewHolder.ivNivelQuestao = (ImageView) findViewById(R.id.iv_nivel_questao);
        this.mViewHolder.btn_responder = (Button) findViewById(R.id.btn_responder);
        this.mViewHolder.rdbItem1 = (RadioButton) findViewById(R.id.rdb_item1);
        this.mViewHolder.rdbItem2 = (RadioButton) findViewById(R.id.rdb_item2);
        this.mViewHolder.rdbItem3 = (RadioButton) findViewById(R.id.rdb_item3);
        this.mViewHolder.rdbItem4 = (RadioButton) findViewById(R.id.rdb_item4);
        this.mViewHolder.cnt_pergunta = (ConstraintLayout) findViewById(R.id.cnt_pergunta);
        this.mViewHolder.cntLinearRadio = (LinearLayout) findViewById(R.id.cnt_linear_radio);
        equipeAtual = new Equipe();
        perguntaBusiness = new PerguntaBusiness(this);
        equipeBusiness = new EquipeBusiness(this);
        this.setListeners();
    }

    private void setListeners() {
        this.mViewHolder.ivConsultar.setOnClickListener(this);
        this.mViewHolder.btn_responder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_consultar) {

            String codigoPesquisado=this.mViewHolder.etCodigoPergunta.getText().toString();

//mudar pergunta para consultada

            pergunta = perguntaBusiness.consultarPerguntaPorCodigo(codigoPesquisado.toUpperCase());
            try {
                this.mViewHolder.tvArea.setText(pergunta.getArea());
                this.mViewHolder.tvEnunciado.setText(pergunta.getEnunciado());
                this.mViewHolder.tvPontosQuestao.setText(pergunta.getPontosPergunta() + " pontos");
                this.mViewHolder.rdbItem1.setText(pergunta.getItemA());
                this.mViewHolder.rdbItem2.setText(pergunta.getItemB());
                this.mViewHolder.rdbItem3.setText(pergunta.getItemC());
                this.mViewHolder.rdbItem4.setText(pergunta.getItemD());

                if (pergunta.getNivel().equalsIgnoreCase("Básico")) {
                    this.mViewHolder.ivNivelQuestao.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.easy));
                } else if (pergunta.getNivel().equalsIgnoreCase("Intermediário")) {
                    this.mViewHolder.ivNivelQuestao.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hard));
                } else if (pergunta.getNivel().equalsIgnoreCase("Avançado")) {
                    this.mViewHolder.ivNivelQuestao.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.very));
                } else if (pergunta.getNivel().equalsIgnoreCase("Final")) {
                    this.mViewHolder.ivNivelQuestao.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.estagiofinal));
                }
                this.deixarVisivel(true);
                if (pergunta.getTipo().equalsIgnoreCase("Subjetiva")) {
                    //se pergunta for subjetiva
                    this.mViewHolder.cntLinearRadio.setVisibility(View.INVISIBLE);
                    this.mViewHolder.etRespostaSubjetiva.setVisibility(View.VISIBLE);
                } else {
                    //se pergunta for objetiva
                    this.mViewHolder.cntLinearRadio.setVisibility(View.VISIBLE);
                    this.mViewHolder.etRespostaSubjetiva.setVisibility(View.INVISIBLE);
                }
                perguntaBusiness.updatePerguntaSorteada(pergunta);
            } catch (NullPointerException ex) {
                Toast.makeText(this, "O código é inválido ou a pergunta já foi sorteada!", Toast.LENGTH_LONG).show();
            }
        }
        if (view.getId() == R.id.btn_responder) {
            this.deixarVisivel(false);
            this.conferirResposta();
        }
    }

    private void conferirResposta() {
        int pontosParaAtualizar=0;
        if (pergunta.getTipo().equalsIgnoreCase("Subjetiva")) {
            if (this.mViewHolder.etRespostaSubjetiva.getText().toString().equalsIgnoreCase(pergunta.getRespostaSubjetiva())) {
                //tocar som resposta correta e abrir activity correta por cima
                //pegar pontos e atribuir para equipe
                pontosParaAtualizar=Integer.parseInt(pergunta.getPontosPergunta())+equipeBusiness.obterPontosEquipe(equipeAtual.getIdEquipe());
                //equipeBusiness.updatePontosEquipe()
            } else {
                //tocar som resposta incorreta e abrir activity incorreta por cima
            }
        } else {

            String itemSelecionado="";
            if (this.mViewHolder.rdbItem1.isChecked()) {
                itemSelecionado = "A";
            } else if (this.mViewHolder.rdbItem1.isChecked()) {
                itemSelecionado = "B";
            } else if (this.mViewHolder.rdbItem2.isChecked()) {
                itemSelecionado = "C";
            } else if (this.mViewHolder.rdbItem3.isChecked()) {
                itemSelecionado = "D";
            } else {
                Toast.makeText(this, "Selecione ao menos um item", Toast.LENGTH_LONG).show();
            }
            if(itemSelecionado.equalsIgnoreCase(pergunta.getItemCorreto())){
                //tocar som resposta correta e abrir activity correta por cima
                //pegar pontos e atribuir para equipe

            } else {
                //tocar som resposta incorreta e abrir activity incorreta por cima
            }


        }
        //FINALIZACAO
        this.limparCampos();
        this.deixarVisivel(false);
    }

    private void limparCampos() {
        this.mViewHolder.rdbItem1.setChecked(false);
        this.mViewHolder.rdbItem2.setChecked(false);
        this.mViewHolder.rdbItem3.setChecked(false);
        this.mViewHolder.rdbItem4.setChecked(false);
        this.mViewHolder.etRespostaSubjetiva.setText("");
    }

    public void deixarVisivel(boolean opcao) {
        if (opcao == true) {
            this.mViewHolder.cnt_pergunta.setVisibility(View.VISIBLE);
            this.mViewHolder.btn_responder.setVisibility(View.VISIBLE);
            this.mViewHolder.tvPontosQuestao.setVisibility(View.VISIBLE);
            this.mViewHolder.ivNivelQuestao.setVisibility(View.VISIBLE);
            this.mViewHolder.etRespostaSubjetiva.setVisibility(View.VISIBLE);
        } else {
            this.mViewHolder.cnt_pergunta.setVisibility(View.INVISIBLE);
            this.mViewHolder.btn_responder.setVisibility(View.INVISIBLE);
            this.mViewHolder.tvPontosQuestao.setVisibility(View.INVISIBLE);
            this.mViewHolder.ivNivelQuestao.setVisibility(View.INVISIBLE);
            this.mViewHolder.etRespostaSubjetiva.setVisibility(View.INVISIBLE);

        }
    }


    private static class ViewHolder {
        TextView tvEnunciado, tvPontosQuestao,tvArea;
        ImageView ivConsultar, ivNivelQuestao;
        EditText etCodigoPergunta, etRespostaSubjetiva;
        Button btn_responder;
        RadioButton rdbItem1, rdbItem2, rdbItem3, rdbItem4;
        ConstraintLayout cnt_pergunta;
        LinearLayout cntLinearRadio;
    }
}
