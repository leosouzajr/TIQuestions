package com.example.leona.tiquestions.entities;

public class Pergunta {
    int idPergunta;
    private String codPergunta;
    private String enunciado;
    private String tipo;
    private String itemA;
    private String itemB;
    private String itemC;
    private String itemD;
    private String respostaSubjetiva;
    private String itemCorreto;
    private String nivel;
    private String pontosPergunta;
    private String foiSorteada;
    private String area;

    public Pergunta(){

    }
    public Pergunta(int idPergunta,String codPergunta, String enunciado, String tipo, String itemA, String itemB, String itemC, String itemD,String respostaSubjetiva, String itemCorreto, String nivel, String pontosPergunta, String area, String foiSorteada) {

       this.idPergunta=idPergunta;
       this.codPergunta = codPergunta;
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.itemA = itemA;
        this.itemB = itemB;
        this.itemC = itemC;
        this.itemD = itemD;
        this.respostaSubjetiva= respostaSubjetiva;
        this.itemCorreto = itemCorreto;
        this.nivel = nivel;
        this.pontosPergunta = pontosPergunta;
        this.foiSorteada = foiSorteada;
        this.area=area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRespostaSubjetiva() {
        return respostaSubjetiva;
    }

    public void setRespostaSubjetiva(String respostaSubjetiva) {
        this.respostaSubjetiva = respostaSubjetiva;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getCodPergunta() {
        return codPergunta;
    }

    public void setCodPergunta(String codPergunta) {
        this.codPergunta = codPergunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getItemA() {
        return itemA;
    }

    public void setItemA(String itemA) {
        this.itemA = itemA;
    }

    public String getItemB() {
        return itemB;
    }

    public void setItemB(String itemB) {
        this.itemB = itemB;
    }

    public String getItemC() {
        return itemC;
    }

    public void setItemC(String itemC) {
        this.itemC = itemC;
    }

    public String getItemD() {
        return itemD;
    }

    public void setItemD(String itemD) {
        this.itemD = itemD;
    }

    public String getItemCorreto() {
        return itemCorreto;
    }

    public void setItemCorreto(String itemCorreto) {
        this.itemCorreto = itemCorreto;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPontosPergunta() {
        return pontosPergunta;
    }

    public void setPontosPergunta(String pontosPergunta) {
        this.pontosPergunta = pontosPergunta;
    }

    public String getFoiSorteada() {
        return foiSorteada;
    }

    public void setFoiSorteada(String foiSorteada) {
        this.foiSorteada = foiSorteada;
    }
}

