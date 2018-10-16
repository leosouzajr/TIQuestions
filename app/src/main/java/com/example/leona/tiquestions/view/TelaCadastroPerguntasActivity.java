package com.example.leona.tiquestions.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leona.tiquestions.R;
import com.example.leona.tiquestions.business.PerguntaBusiness;
import com.example.leona.tiquestions.constants.ConstantsApp;
import com.example.leona.tiquestions.entities.Pergunta;
import com.example.leona.tiquestions.util.DadosLocais;

public class TelaCadastroPerguntasActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static ViewHolder mViewHolder = new ViewHolder();
    private String nivelSelecionado = "", tipoPerguntaSelecionado = "";
    private String areaSelecionada = "";
    private String itemCorretoSelecionado = "", enunciadoPergunta = "", itemA = "", itemB = "", itemC = "", itemD = "", respostaSubejtiva = "";
    private String pontos = "";
    private PerguntaBusiness perguntaBusiness;
    private String siglaNivel="";
    private int resM1;
    private int resM2;
    private String codigoPergunta;
    private static DadosLocais dadosLocais;
    private int idAtual;
    private int m1Atual,m2Atual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_cadastro_perguntas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dadosLocais = new DadosLocais(this);
        perguntaBusiness = new PerguntaBusiness(this);

        this.mViewHolder.fab = (FloatingActionButton) findViewById(R.id.fab);
        this.mViewHolder.tvId = (TextView) findViewById(R.id.tv_id_a_mostrar);
        this.mViewHolder.etEnunciado = (EditText) findViewById(R.id.et_enunciado);
        this.mViewHolder.etItemAEnun = (EditText) findViewById(R.id.et_item_a_enun);
        this.mViewHolder.etItemBEnun = (EditText) findViewById(R.id.et_item_b_enun);
        this.mViewHolder.etItemCEnun = (EditText) findViewById(R.id.et_item_C_enun);
        this.mViewHolder.etItemDEnun = (EditText) findViewById(R.id.et_item_D_enun);
        this.mViewHolder.etPontos = (EditText) findViewById(R.id.et_pontos);
        this.mViewHolder.etRespostaSubjetiva = (EditText) findViewById(R.id.et_resposta_subjetiva);
        this.mViewHolder.spnTipoPergunta = (Spinner) findViewById(R.id.spn_tipo_pergunta);
        this.mViewHolder.spnItemCorreto = (Spinner) findViewById(R.id.spn_item_correto);
        this.mViewHolder.spnNivel = (Spinner) findViewById(R.id.spn_nivel);
        this.mViewHolder.spnArea = (Spinner) findViewById(R.id.spn_area);
        Toast.makeText(this, "quantidade de perguntas cadastradas:"+perguntaBusiness.consultarPerguntas().size(),Toast.LENGTH_SHORT).show();
    if(perguntaBusiness.consultarPerguntas().size()==0){
        dadosLocais.inserirIdAtual(ConstantsApp.CHAVEID,1);
        dadosLocais.inserirM1Atual(ConstantsApp.CHAVEM1,3);
        dadosLocais.inserirM2Atual(ConstantsApp.CHAVEM2,7);
        Toast.makeText(this, "zerou dados Locais",Toast.LENGTH_SHORT).show();
    }else{
        dadosLocais.inserirIdAtual(ConstantsApp.CHAVEID,perguntaBusiness.consultarPerguntas().size()+1);
        Toast.makeText(this, "quantidade de perguntas cadastradas:"+perguntaBusiness.consultarPerguntas().size(),Toast.LENGTH_SHORT).show();
    }
      this.mViewHolder.tvId.setText(""+dadosLocais.pegarIdAtual(ConstantsApp.CHAVEID));
        this.setListeners();
    }

    private void setListeners() {
        this.mViewHolder.fab.setOnClickListener(this);
        this.mViewHolder.spnNivel.setOnItemSelectedListener(this);
        this.mViewHolder.spnTipoPergunta.setOnItemSelectedListener(this);
        this.mViewHolder.spnArea.setOnItemSelectedListener(this);
        this.mViewHolder.spnItemCorreto.setOnItemSelectedListener(this);
    }

    public void mudarEditaveis() {
        if (tipoPerguntaSelecionado.equalsIgnoreCase("Subjetiva")) {
            this.mViewHolder.etEnunciado.setEnabled(true);
            this.mViewHolder.etItemAEnun.setEnabled(false);
            this.mViewHolder.etItemBEnun.setEnabled(false);
            this.mViewHolder.etItemCEnun.setEnabled(false);
            this.mViewHolder.etItemDEnun.setEnabled(false);
            this.mViewHolder.etItemAEnun.setText("");
            this.mViewHolder.etItemBEnun.setText("");
            this.mViewHolder.etItemCEnun.setText("");
            this.mViewHolder.etItemDEnun.setText("");
            this.mViewHolder.spnItemCorreto.setEnabled(false);
            this.mViewHolder.etRespostaSubjetiva.setEnabled(true);
        } else if (tipoPerguntaSelecionado.equalsIgnoreCase("Objetiva")){
            this.mViewHolder.etEnunciado.setEnabled(true);
            this.mViewHolder.etEnunciado.setEnabled(true);
            this.mViewHolder.etItemAEnun.setEnabled(true);
            this.mViewHolder.etItemBEnun.setEnabled(true);
            this.mViewHolder.etItemCEnun.setEnabled(true);
            this.mViewHolder.etItemDEnun.setEnabled(true);
            this.mViewHolder.spnItemCorreto.setEnabled(true);
            this.mViewHolder.etRespostaSubjetiva.setEnabled(false);
            this.mViewHolder.etRespostaSubjetiva.setText("");
        }else{
            this.mViewHolder.etEnunciado.setEnabled(false);
            this.mViewHolder.etEnunciado.setText("");
            this.mViewHolder.spnItemCorreto.setSelection(0);
            this.mViewHolder.spnNivel.setSelection(0);
            this.mViewHolder.spnArea.setSelection(0);
            this.mViewHolder.spnTipoPergunta.setSelection(0);
            this.mViewHolder.etItemAEnun.setEnabled(false);
            this.mViewHolder.etItemBEnun.setEnabled(false);
            this.mViewHolder.etItemCEnun.setEnabled(false);
            this.mViewHolder.etItemDEnun.setEnabled(false);
            this.mViewHolder.etItemAEnun.setText("");
            this.mViewHolder.etItemBEnun.setText("");
            this.mViewHolder.etItemCEnun.setText("");
            this.mViewHolder.etItemDEnun.setText("");
            this.mViewHolder.spnItemCorreto.setEnabled(false);
            this.mViewHolder.etRespostaSubjetiva.setEnabled(true);
            this.mViewHolder.etRespostaSubjetiva.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            this.handleSave();
        }
    }

    private void handleSave() {
        enunciadoPergunta = this.mViewHolder.etEnunciado.getText().toString();
        itemA = this.mViewHolder.etItemAEnun.getText().toString();
        itemB = this.mViewHolder.etItemBEnun.getText().toString();
        itemC = this.mViewHolder.etItemBEnun.getText().toString();
        itemD = this.mViewHolder.etItemBEnun.getText().toString();
        pontos = this.mViewHolder.etPontos.getText().toString();
        idAtual=dadosLocais.pegarIdAtual(ConstantsApp.CHAVEID);
        m1Atual=dadosLocais.pegarM1Atual(ConstantsApp.CHAVEM1);
        m2Atual=dadosLocais.pegarM1Atual(ConstantsApp.CHAVEM2);

        resM2= idAtual* m2Atual;
        resM1= idAtual* m1Atual;
        codigoPergunta=siglaNivel+resM1+resM2;
        respostaSubejtiva = this.mViewHolder.etRespostaSubjetiva.getText().toString();

        if (tipoPerguntaSelecionado.equalsIgnoreCase("Objetiva") || tipoPerguntaSelecionado.equalsIgnoreCase("Subjetiva")) {
            if (this.validados(tipoPerguntaSelecionado)) {
                //gerar codigo de acordo com formula
                //area(H/R/D) + nivel(E/H/V/F) + (ID * NUM MULTIPLICADOR 1) + (ID * NUM MULTIPLICADOR 1)
                Pergunta pergunta = new Pergunta(idAtual,codigoPergunta, enunciadoPergunta,
                        tipoPerguntaSelecionado, itemA, itemB, itemC, itemD, respostaSubejtiva, itemCorretoSelecionado,
                        nivelSelecionado, pontos, areaSelecionada, "Não");
                Toast.makeText(this, "Codigo:" + codigoPergunta, Toast.LENGTH_LONG).show();

                if(perguntaBusiness.insert(pergunta)){
                    Toast.makeText(this, "Questão inserida com sucesso!", Toast.LENGTH_LONG).show();
                    dadosLocais.inserirIdAtual(ConstantsApp.CHAVEID,++idAtual);
                    dadosLocais.inserirM1Atual(ConstantsApp.CHAVEM1,++m1Atual);
                    dadosLocais.inserirM2Atual(ConstantsApp.CHAVEM2,++m2Atual);
                    this.finishAffinity();
                    startActivity(new Intent(this, TelaCadastroPerguntasActivity.class));
                }else{
                    Toast.makeText(this, "Erro na inserção!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Ainda existem campos não preenchidos", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "Não foi selecionado o tipo de pergunta(OBJETIVA/SUBJETIVA)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validados(String tipoPerguntaSelecionado) {
        boolean valido = false;
        if (tipoPerguntaSelecionado.equalsIgnoreCase("Objetiva")) {
            if (!(enunciadoPergunta.equalsIgnoreCase("")) && !(itemA.equalsIgnoreCase("")) &&
                    !(itemB.equalsIgnoreCase("")) && !(itemC.equalsIgnoreCase("")) &&
                    !(itemD.equalsIgnoreCase("")) && !(itemCorretoSelecionado.equalsIgnoreCase("")) &&
                    !(nivelSelecionado.equalsIgnoreCase("")) && !(areaSelecionada.equalsIgnoreCase(""))) {
                valido = true;
            }
        } else {
            if (!(enunciadoPergunta.equalsIgnoreCase("")) &&
                    !(respostaSubejtiva.equalsIgnoreCase("")) &&
                    !(nivelSelecionado.equalsIgnoreCase("")) && !(areaSelecionada.equalsIgnoreCase(""))) {
                valido = true;
            }
        }
        return valido;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.spn_nivel) {
            nivelSelecionado = this.mViewHolder.spnNivel.getSelectedItem().toString();
            if (nivelSelecionado.equalsIgnoreCase("Nível")) {


                nivelSelecionado = "";


            } else if (nivelSelecionado.equalsIgnoreCase("Básico")) {
                this.mViewHolder.etPontos.setText("4");
                siglaNivel="B";
            } else if (nivelSelecionado.equalsIgnoreCase("Intermediário")) {
                this.mViewHolder.etPontos.setText("7");
                siglaNivel="I";
            } else if (nivelSelecionado.equalsIgnoreCase("Avançado")) {
                this.mViewHolder.etPontos.setText("12");
                siglaNivel="A";
            } else if (nivelSelecionado.equalsIgnoreCase("Final")) {
                this.mViewHolder.etPontos.setText("23");
                siglaNivel="F";
            }
        }
        if (adapterView.getId() == R.id.spn_tipo_pergunta) {
            tipoPerguntaSelecionado = this.mViewHolder.spnTipoPergunta.getSelectedItem().toString();
            if (tipoPerguntaSelecionado.equalsIgnoreCase("Tipo resposta")) {


                tipoPerguntaSelecionado = "";
            } else if (tipoPerguntaSelecionado.equalsIgnoreCase("Objetiva")) {
                this.mudarEditaveis();
            } else if (tipoPerguntaSelecionado.equalsIgnoreCase("Subjetiva")) {
                this.mudarEditaveis();
            }
        }
        if (adapterView.getId() == R.id.spn_area) {
            if (!this.mViewHolder.spnArea.getSelectedItem().toString().equalsIgnoreCase("Área")) {
                areaSelecionada = this.mViewHolder.spnArea.getSelectedItem().toString();
            } else {
                areaSelecionada="";
            }
        }
        if (adapterView.getId() == R.id.spn_item_correto) {
            if (!this.mViewHolder.spnItemCorreto.getSelectedItem().toString().equalsIgnoreCase("Item correto...")) {
                itemCorretoSelecionado = this.mViewHolder.spnItemCorreto.getSelectedItem().toString();
            } else {
                itemCorretoSelecionado="";

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private static class ViewHolder {
        TextView tvId;
        EditText etEnunciado, etPontos, etItemAEnun,
                etItemBEnun, etItemCEnun, etItemDEnun, etRespostaSubjetiva;
        FloatingActionButton fab;
        Spinner spnTipoPergunta, spnNivel, spnItemCorreto, spnArea;
    }

}
