package org.example.questao1_2_3.model;

public class MedicoPlantonista extends Medico {
    private String turno;

    public MedicoPlantonista(String nome, String crm, String especialidade, String turno) {
        super(nome, crm, especialidade);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }


}

