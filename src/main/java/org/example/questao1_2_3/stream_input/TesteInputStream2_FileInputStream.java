package org.example.questao1_2_3.stream_input;

import org.example.questao1_2_3.model.Medico;
import java.io.FileInputStream;

public class TesteInputStream2_FileInputStream {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("medicos.dat");
             MedicoInputStream mis = new MedicoInputStream(fis)) {

            Medico[] medicos = mis.lerMedicos(2); // número de médicos
            for (Medico m : medicos) {
                System.out.println(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
