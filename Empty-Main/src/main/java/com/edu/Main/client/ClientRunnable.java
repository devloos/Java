package com.edu.Main.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.edu.Main.serialize.*;

import com.edu.Main.messages.*;

public class ClientRunnable implements Runnable {

    private Socket socket;
    private BufferedReader input;

    public ClientRunnable(Socket s) throws IOException {
        // initialize variables
        this.socket = s;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    @Override
    public void run() {
        try {
            while (true) {
                String response = input.readLine();
                Packet packet;
                packet = SerializerFactory.getSerializer().deserialize(response);
                // if the received message isn't from a client
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
