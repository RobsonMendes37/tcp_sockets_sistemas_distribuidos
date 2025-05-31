package org.example.questao5.server;

import org.example.questao5.model.Usuario;
import org.example.questao5.util.JsonUtils;

import java.io.*;
import java.net.Socket;

public class ThreadCliente extends Thread {
    private final Socket socket;
    private final GerenciadorVotacao gerenciador;

    public ThreadCliente(Socket socket, GerenciadorVotacao gerenciador) {
        this.socket = socket;
        this.gerenciador = gerenciador;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            String loginJson = in.readLine();
            Usuario usuario = JsonUtils.fromJson(loginJson, Usuario.class);
            if (usuario.getTipo().equals("eleitor")) {
                out.write(JsonUtils.toJson(gerenciador.listarCandidatos()));
                out.newLine();
                out.flush();

                String voto = in.readLine();
                gerenciador.votar(voto);
                out.write("Voto recebido.");
                out.newLine();
                out.flush();
            } else if (usuario.getTipo().equals("admin")) {
                String comando = in.readLine();
                if (comando.startsWith("add:")) {
                    gerenciador.adicionarCandidato(comando.substring(4));
                    out.write("Candidato adicionado.");
                } else if (comando.startsWith("remove:")) {
                    gerenciador.removerCandidato(comando.substring(7));
                    out.write("Candidato removido.");
                }
                out.newLine();
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
