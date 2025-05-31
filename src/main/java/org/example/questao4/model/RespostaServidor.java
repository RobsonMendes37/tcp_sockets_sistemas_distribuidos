package org.example.questao4.model;

import java.io.Serializable;

public class RespostaServidor implements Serializable {
    private boolean sucesso;
    private String mensagem;

    public RespostaServidor(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "RespostaServidor{" +
                "sucesso=" + sucesso +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
