package com.edu.Main.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.edu.Main.messages.*;
import com.edu.Main.serialize.*;

import javafx.util.Pair;
import lombok.Getter;

@Getter
public class ServerThread extends Thread {

    private Socket socket = null;
    private RouterThread routerThread = null;
    private BufferedReader input = null;
    private PrintWriter output = null;

    public ServerThread(Socket socket, RouterThread routerThread) {
        this.socket = socket;
        this.routerThread = routerThread;
        try {
            input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            output = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String clientMessage = input.readLine();

                Packet<Message> packet = SerializerFactory.getSerializer().deserialize(clientMessage);

                routerThread.addJob(new Pair<ServerThread, Packet<Message>>(this, packet));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
