package org.example;

import org.example.questao1_2_3.model.Enfermeiro;
import org.example.questao1_2_3.model.Medico;
import org.example.questao1_2_3.model.MedicoEfetivo;
import org.example.questao1_2_3.model.MedicoPlantonista;
import org.example.questao1_2_3.service.EscalaService;
import org.example.questao1_2_3.service.RHService;

public class Main {
    public static void main(String[] args) {
        RHService rhService = new RHService();

        MedicoPlantonista mp = new MedicoPlantonista("Dr. João", "12345", "Clínico Geral", "Noite");
        MedicoEfetivo me = new MedicoEfetivo("Dra. Ana", "67890", "Pediatria", 160);
        Enfermeiro enf = new Enfermeiro("Maria", "11111", "UTI");

        rhService.cadastrarMedico(mp);
        rhService.cadastrarMedico(me);
        rhService.cadastrarEnfermeiro(enf);

        System.out.println("----- Médicos Cadastrados -----");
        for (Medico m : rhService.listarMedicos()) {
            System.out.println(m.getNome() + " - " + m.getEspecialidade());
        }

        System.out.println("\n----- Enfermeiros Cadastrados -----");
        for (Enfermeiro e : rhService.listarEnfermeiros()) {
            System.out.println(e.getNome() + " - " + e.getSetor());
        }

        EscalaService escala = new EscalaService();
        System.out.println("\nEscala da semana: " + escala.gerarEscala());
    }
}
