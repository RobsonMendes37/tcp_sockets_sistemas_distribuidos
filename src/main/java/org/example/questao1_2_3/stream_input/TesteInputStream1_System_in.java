package org.example.questao1_2_3.stream_input;

import org.example.questao1_2_3.model.Medico;

public class TesteInputStream1_System_in {
    public static void main(String[] args) {
        try (MedicoInputStream mis = new MedicoInputStream(System.in)) {
            Medico[] medicos = mis.lerMedicos(2); // le 2 médicos da entrada padrão
            for (Medico m : medicos) {
                System.out.println("Recebido: " + m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
