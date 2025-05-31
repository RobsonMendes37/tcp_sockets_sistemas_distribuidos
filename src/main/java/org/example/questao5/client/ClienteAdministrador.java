package org.example.questao5.client;


import org.example.questao5.model.Usuario;
import org.example.questao5.util.JsonUtils;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteAdministrador {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);

        Usuario admin = new Usuario("Admin", "admin");
        out.write(JsonUtils.toJson(admin));
        out.newLine();
        out.flush();

        System.out.print("Comando (add:Nome ou remove:Nome): ");
        String comando = scanner.nextLine();
        out.write(comando);
        out.newLine();
        out.flush();
        System.out.println("Servidor: " + in.readLine());

        // Multicast de nota informativa
        System.out.print("Deseja enviar nota informativa? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            MulticastSocket udpSocket = new MulticastSocket();
            InetAddress grupo = InetAddress.getByName("230.0.0.0");
            System.out.print("Digite a nota: ");
            String nota = scanner.nextLine();
            byte[] msg = nota.getBytes();
            DatagramPacket packet = new DatagramPacket(msg, msg.length, grupo, 4446);
            udpSocket.send(packet);
            udpSocket.close();
            System.out.println("Nota enviada- via UDP multicast.");
        }

        socket.close();
    }
}

