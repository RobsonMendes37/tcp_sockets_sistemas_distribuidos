package org.example.questao1_2_3.service;

import org.example.questao1_2_3.interfaces.Escala;

public class EscalaService implements Escala {

    @Override
    public String gerarEscala() {
        return "Escala gerada: Médico Plantonista - Noite | Enfermeiro - Manhã";
    }
}
