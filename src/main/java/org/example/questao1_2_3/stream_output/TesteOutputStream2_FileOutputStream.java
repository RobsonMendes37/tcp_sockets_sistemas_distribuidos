package org.example.questao1_2_3.stream_output;

import org.example.questao1_2_3.model.Medico;
import java.io.FileOutputStream;

public class TesteOutputStream2_FileOutputStream {
    public static void main(String[] args) {
        Medico[] medicos = {
                new Medico("Dr. João", "12345", "Clínico Geral"),
                new Medico("Dra. Ana", "67890", "Pediatria")
        };

        try (FileOutputStream fos = new FileOutputStream("medicos.dat");
             MedicoOutputStream mos = new MedicoOutputStream(medicos, medicos.length, fos)) {
            mos.enviarDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
