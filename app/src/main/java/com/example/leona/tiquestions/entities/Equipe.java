package com.example.leona.tiquestions.entities;

public class Equipe {
    int idEquipe;
    private String nomeEquipe;
    private String pontosEquipe;

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getPontosEquipe() {
        return pontosEquipe;
    }

    public void setPontosEquipe(String pontosEquipe) {
        this.pontosEquipe = pontosEquipe;
    }
}
