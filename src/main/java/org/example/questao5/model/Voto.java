package org.example.questao5.model;

public class Voto {
    private String eleitor;
    private String candidato;

    public Voto(String eleitor, String candidato) {
        this.eleitor = eleitor;
        this.candidato = candidato;
    }

    public String getEleitor() { return eleitor; }
    public String getCandidato() { return candidato; }
}
