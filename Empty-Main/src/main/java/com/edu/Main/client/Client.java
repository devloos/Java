package com.edu.Main.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import com.edu.Main.messages.client.*;
import com.edu.Main.messages.server.*;
import com.edu.Main.messages.*;
import com.edu.Main.serialize.*;

import java.util.UUID;

public class Client {

    public static final int port = 8000;
    public static final String host = "localhost";

    public static void main(String[] args) throws InterruptedException {
        try (Socket socket = new Socket(host, port)) {
            UUID socketID = UUID.randomUUID();

            // return the output to the server : true statement is to flush the buffer
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            ClientRunnable clientRun = new ClientRunnable(socket);

            Thread clientThread = new Thread(clientRun);
            clientThread.start();

            do {
                // decide which message to send, and what data
                CreateGame message = new CreateGame("dgeyfman");

                Packet packet = new Packet(message, "/abc");
                String jsonStr = SerializerFactory.getSerializer().serialize(packet);
                output.println(jsonStr);

                // just to send packet every second instead of every frame
                Thread.sleep(1000);

                // change this to while user doesn't want to exit the game
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
