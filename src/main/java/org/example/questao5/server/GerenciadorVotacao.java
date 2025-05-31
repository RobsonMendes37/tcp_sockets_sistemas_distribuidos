package org.example.questao5.server;

import org.example.questao5.model.Candidato;

import java.util.*;

public class GerenciadorVotacao {
    private final Map<String, Candidato> candidatos = new HashMap<>();
    private boolean votacaoAberta = true;

    public synchronized void adicionarCandidato(String nome) {
        candidatos.putIfAbsent(nome, new Candidato(nome));
    }

    public synchronized void removerCandidato(String nome) {
        candidatos.remove(nome);
    }

    public synchronized List<Candidato> listarCandidatos() {
        return new ArrayList<>(candidatos.values());
    }

    public synchronized boolean votar(String nomeCandidato) {
        if (!votacaoAberta) return false;
        Candidato c = candidatos.get(nomeCandidato);
        if (c != null) {
            c.adicionarVoto();
            return true;
        }
        return false;
    }

    public synchronized void encerrarVotacao() {
        votacaoAberta = false;
    }

    public synchronized boolean isVotacaoAberta() {
        return votacaoAberta;
    }

    public synchronized String resultadoFinal() {
        StringBuilder sb = new StringBuilder();
        int total = candidatos.values().stream().mapToInt(Candidato::getVotos).sum();

        for (Candidato c : candidatos.values()) {
            double perc = total == 0 ? 0 : ((double) c.getVotos() / total) * 100;
            sb.append(c.getNome())
                    .append(": ")
                    .append(c.getVotos())
                    .append(" votos (")
                    .append(String.format("%.2f", perc))
                    .append("%)\n");
        }

        Optional<Candidato> vencedor = candidatos.values().stream().max(Comparator.comparingInt(Candidato::getVotos));
        vencedor.ifPresent(v -> sb.append("Vencedor: ").append(v.getNome()));
        return sb.toString();
    }
}

