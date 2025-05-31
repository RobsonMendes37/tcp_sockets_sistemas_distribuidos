package org.example.questao1_2_3.stream_output;

import org.example.questao1_2_3.model.Medico;
import java.io.IOException;
import java.io.OutputStream;

public class MedicoOutputStream extends OutputStream {
    private Medico[] medicos;
    private int quantidade;
    private OutputStream destino;

    public MedicoOutputStream(Medico[] medicos, int quantidade, OutputStream destino) {
        this.medicos = medicos;
        this.quantidade = quantidade;
        this.destino = destino;
    }

    @Override
    public void write(int b) throws IOException {
        destino.write(b);
    }

    public void enviarDados() throws IOException {
        for (int i = 0; i < quantidade; i++) {
            Medico m = medicos[i];
            // Enviar 3 atributos como bytes: nome, CRM, especialidade
            escreverString(m.getNome());
            escreverString(m.getCrm());
            escreverString(m.getEspecialidade());
        }
        destino.flush();
    }

    private void escreverString(String valor) throws IOException {
        byte[] dados = valor.getBytes("UTF-8");
        destino.write(dados.length); // escreve tamanho da string
        destino.write(dados);        // escreve os bytes da string
    }
}

