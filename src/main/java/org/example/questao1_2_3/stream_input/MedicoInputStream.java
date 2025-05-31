package org.example.questao1_2_3.stream_input;

import org.example.questao1_2_3.model.Medico;

import java.io.IOException;
import java.io.InputStream;

public class MedicoInputStream extends InputStream {
    private InputStream origem;

    public MedicoInputStream(InputStream origem) {
        this.origem = origem;
    }

    @Override
    public int read() throws IOException {
        return origem.read();
    }

    public Medico[] lerMedicos(int quantidade) throws IOException {
        Medico[] medicos = new Medico[quantidade];

        for (int i = 0; i < quantidade; i++) {
            String nome = lerString();
            String crm = lerString();
            String especialidade = lerString();
            medicos[i] = new Medico(nome, crm, especialidade);
        }

        return medicos;
    }

    private String lerString() throws IOException {
        int tamanho = origem.read(); // lê o tamanho da string
        if (tamanho == -1) return null;

        byte[] buffer = new byte[tamanho];
        int lidos = origem.read(buffer);
        return new String(buffer, 0, lidos, "UTF-8");
    }
}
