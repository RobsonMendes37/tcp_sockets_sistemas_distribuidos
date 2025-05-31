package org.example.questao1_2_3.model;

public class MedicoEfetivo extends Medico {
    private int cargaHorariaMensal;

    public MedicoEfetivo(String nome, String crm, String especialidade, int cargaHorariaMensal) {
        super(nome, crm, especialidade);
        this.cargaHorariaMensal = cargaHorariaMensal;
    }

    public int getCargaHorariaMensal() {
        return cargaHorariaMensal;
    }

    public void setCargaHorariaMensal(int cargaHorariaMensal) {
        this.cargaHorariaMensal = cargaHorariaMensal;
    }

}
