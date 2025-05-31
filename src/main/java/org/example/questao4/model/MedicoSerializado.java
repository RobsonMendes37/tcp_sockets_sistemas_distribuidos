package org.example.questao4.model;

import java.io.Serializable;

public class MedicoSerializado implements Serializable {
    private String nome;
    private String crm;
    private String especialidade;

    public MedicoSerializado(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}

