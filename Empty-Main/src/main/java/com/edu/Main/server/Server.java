package com.edu.Main.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.edu.Main.messages.*;

public class Server {

    public static final int port = 8000;
    public List<Message> messageList = new ArrayList<Message>();

    public static void main(String[] args) {
        RouterThread routerThread = new RouterThread();
        routerThread.start();

        // create server socket
        try (ServerSocket serversocket = new ServerSocket(port)) {

            // continuously accept and process incoming connections in a new thread
            while (true) {

                Socket socket = serversocket.accept();

                ServerThread serverThread = new ServerThread(socket, routerThread);
                serverThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
