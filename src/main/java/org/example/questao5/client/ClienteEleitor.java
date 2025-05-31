package org.example.questao5.client;

import org.example.questao5.model.Usuario;
import org.example.questao5.util.JsonUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEleitor {
    public static void main(String[] args) throws IOException {
        new NotaInformativaListener().start(); // Inicia escuta UDP multicast

        Socket socket = new Socket("localhost", 12345);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);

        Usuario eleitor = new Usuario("João", "eleitor");
        out.write(JsonUtils.toJson(eleitor));
        out.newLine();
        out.flush();

        String candidatosJson = in.readLine();
        System.out.println("Candidatos disponíveis: " + candidatosJson);
        System.out.print("Seu voto: ");
        String voto = scanner.nextLine();

        out.write(voto);
        out.newLine();
        out.flush();

        System.out.println("Servidor: " + in.readLine());

        socket.close();
    }
}
