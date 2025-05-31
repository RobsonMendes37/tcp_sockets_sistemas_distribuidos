package org.example.questao1_2_3.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nome;
    private List<Medico> medicos;
    private List<Enfermeiro> enfermeiros;

    public Hospital(String nome) {
        this.nome = nome;
        this.medicos = new ArrayList<>();
        this.enfermeiros = new ArrayList<>();
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void adicionarEnfermeiro(Enfermeiro enfermeiro) {
        enfermeiros.add(enfermeiro);
    }

    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

}