package org.example.questao1_2_3.model;

public class Enfermeiro {
    private String nome;
    private String coren;
    private String setor;

    public Enfermeiro(String nome, String coren, String setor) {
        this.nome = nome;
        this.coren = coren;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
