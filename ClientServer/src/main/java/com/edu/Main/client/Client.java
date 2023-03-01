package com.edu.Main.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

class ClientThread extends Thread {
  public ClientThread(Socket socket) {
    this.socket = socket;
    this.thread_name = this.getName();
    this.socket_local_port = this.socket.getLocalPort();
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

  public void exec() throws InterruptedException, IOException {
    System.out.println(thread_name + " is processing on socket: " + socket_local_port);

    Random random = new Random();
    Thread.sleep(random.nextLong(9000, 15000));

    System.out.println(thread_name + " is shutting socket: " + socket_local_port + " off.");
    socket.close();
  }

  private Socket socket = null;
  private String thread_name = null;
  private int socket_local_port = 0;
}

public class Client {
  public static ArrayList<ClientThread> threads = new ArrayList<ClientThread>();

  public static void main(String[] args) throws UnknownHostException, IOException {
    System.out.println("Booting up computers...\n");

    for (int i = 0; i < 4; ++i) {
      Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
      ClientThread mock_computer = new ClientThread(socket);
      mock_computer.start();
      threads.add(mock_computer);
    }
  }
}