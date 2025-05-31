package org.example.questao5.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class ServidorVotacao {
    public static void main(String[] args) throws IOException {
        GerenciadorVotacao gerenciador = new GerenciadorVotacao();
        ServerSocket serverSocket = new ServerSocket(12345);

        // Timer para encerrar votação após 30 segundos
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                gerenciador.encerrarVotacao();
                System.out.println("\nVotação encerrada!\n" + gerenciador.resultadoFinal());
            }
        }, 160000);

        System.out.println("Servidor de votação ativo...");

        while (true) {
            Socket socket = serverSocket.accept();
            new ThreadCliente(socket, gerenciador).start();
        }
    }
}

