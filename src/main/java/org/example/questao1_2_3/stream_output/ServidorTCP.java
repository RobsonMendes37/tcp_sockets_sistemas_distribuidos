package org.example.questao1_2_3.stream_output;

import org.example.questao1_2_3.model.Medico;
import org.example.questao1_2_3.stream_input.MedicoInputStream;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Servidor aguardando conexão...");

            Socket socket = serverSocket.accept();
            System.out.println("Conectado de: " + socket.getInetAddress());

            InputStream in = socket.getInputStream();
            MedicoInputStream mis = new MedicoInputStream(in);
            Medico[] medicos = mis.lerMedicos(2);

            for (Medico m : medicos) {
                System.out.println("Servidor recebeu: " + m);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
