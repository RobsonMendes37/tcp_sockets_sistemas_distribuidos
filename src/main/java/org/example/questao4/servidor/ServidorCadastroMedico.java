package org.example.questao4.servidor;

import org.example.questao4.model.MedicoSerializado;
import org.example.questao4.model.RespostaServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCadastroMedico {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Servidor aguardando conexão...");

            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

                // Desempacota a requisição
                MedicoSerializado medicoRecebido = (MedicoSerializado) entrada.readObject();
                System.out.println("Servidor recebeu: " + medicoRecebido);

                // Processa e empacota resposta
                RespostaServidor resposta = new RespostaServidor(true, "Médico cadastrado com sucesso: " + medicoRecebido);
                saida.writeObject(resposta);

                cliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
