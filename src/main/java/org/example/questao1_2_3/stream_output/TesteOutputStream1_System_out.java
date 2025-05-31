package org.example.questao1_2_3.stream_output;

import org.example.questao1_2_3.model.Medico;

public class TesteOutputStream1_System_out {
    public static void main(String[] args) {
        Medico[] medicos = {
                new Medico("Dr. João", "12345", "Clínico Geral"),
                new Medico("Dra. Ana", "67890", "Pediatria")
        };

        try (MedicoOutputStream mos = new MedicoOutputStream(medicos, medicos.length, System.out)) {
            mos.enviarDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

