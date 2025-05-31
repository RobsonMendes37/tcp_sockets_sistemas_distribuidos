package org.example.questao4.cliente;

import org.example.questao4.model.MedicoSerializado;
import org.example.questao4.model.RespostaServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteCadastroMedico {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000)) {
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            // Cria objeto e empacota
            MedicoSerializado medico = new MedicoSerializado("Dr. Pedro", "11111", "Ortopedia");
            saida.writeObject(medico);

            // Desempacota resposta
            RespostaServidor resposta = (RespostaServidor) entrada.readObject();
            System.out.println("Resposta do servidor: " + resposta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

