package org.example.questao5.model;

public class Candidato {
    private String nome;
    private int votos;

    public Candidato(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() { return nome; }
    public int getVotos() { return votos; }
    public void adicionarVoto() { this.votos++; }
}
