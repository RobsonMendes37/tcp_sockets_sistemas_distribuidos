package org.example.questao1_2_3.stream_input;


import org.example.questao1_2_3.model.Medico;
import org.example.questao1_2_3.stream_output.MedicoOutputStream;

import java.io.OutputStream;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        Medico[] medicos = {
                new Medico("Dr. João", "12345", "Clínico Geral"),
                new Medico("Dra. Ana", "67890", "Pediatria")
        };

        try (Socket socket = new Socket("localhost", 5001)) {
            OutputStream out = socket.getOutputStream();
            MedicoOutputStream mos = new MedicoOutputStream(medicos, medicos.length, out);
            mos.enviarDados();
            mos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
