package com.edu.Main;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

class GameThread extends Thread {
    public GameThread(Socket socket) throws IOException {
        this.socket = socket;
        this.stdin = socket.getInputStream();
        this.thread_name = this.getName();
        this.socket_port = this.socket.getPort();
    }

    public void run() {
        try {
            exec();
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void exec() throws InterruptedException, IOException {
        System.out.println(thread_name + " is processing on socket: " + socket_port);

        Random random = new Random();
        Thread.sleep(random.nextLong(4000, 8000));

        System.out.println(thread_name + " is chatting on socket: " + socket_port);

        stdin.read();
        System.out.println(thread_name + " is closing connection on socket: " + socket_port);
    }

    private Socket socket = null;
    private InputStream stdin = null;
    private String thread_name = null;
    private int socket_port = 0;
}

public class Server {
    public static ArrayList<GameThread> threads = new ArrayList<GameThread>();

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(3000);

        System.out.println("Awaiting socket connections...\n");

        for (int i = 0; i < 4; ++i) {
            Socket socket = server.accept();
            GameThread spawn = new GameThread(socket);
            spawn.start();
            threads.add(spawn);
        }

        server.close();
    }

}