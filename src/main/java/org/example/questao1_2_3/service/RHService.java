package org.example.questao1_2_3.service;

import org.example.questao1_2_3.model.Medico;
import org.example.questao1_2_3.model.Enfermeiro;
import java.util.ArrayList;
import java.util.List;

public class RHService {
    private List<Medico> medicos = new ArrayList<>();
    private List<Enfermeiro> enfermeiros = new ArrayList<>();

    public void cadastrarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void cadastrarEnfermeiro(Enfermeiro enfermeiro) {
        enfermeiros.add(enfermeiro);
    }

    public List<Medico> listarMedicos() {
        return medicos;
    }

    public List<Enfermeiro> listarEnfermeiros() {
        return enfermeiros;
    }
}