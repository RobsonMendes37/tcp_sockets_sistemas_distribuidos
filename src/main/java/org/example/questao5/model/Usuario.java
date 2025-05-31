package org.example.questao5.model;

public class Usuario {
    private String nome;
    private String tipo; // "eleitor" ou "admin"

    public Usuario(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
}
