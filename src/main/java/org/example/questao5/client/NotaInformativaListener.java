package org.example.questao5.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class NotaInformativaListener extends Thread {
    private static final String MULTICAST_ADDRESS = "230.0.0.0";
    private static final int MULTICAST_PORT = 4446;

    @Override
    public void run() {
        try (MulticastSocket socket = new MulticastSocket(MULTICAST_PORT)) {
            InetAddress group = InetAddress.getByName(MULTICAST_ADDRESS);
            socket.joinGroup(group);

            byte[] buffer = new byte[1024];
            System.out.println("[INFO] Aguardando notas informativas...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String nota = new String(packet.getData(), 0, packet.getLength());
                System.out.println("\n[NOTA INFORMATIVA] " + nota);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
