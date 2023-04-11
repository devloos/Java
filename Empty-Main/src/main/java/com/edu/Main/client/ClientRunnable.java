package com.edu.Main.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.edu.Main.serialize.*;

import javafx.util.Pair;

import com.edu.Main.messages.*;

public class ClientRunnable implements Runnable {

  private Socket socket = null;
  private String username = null;
  private PrintWriter output = null;
  private Scanner cin = null;

  public ClientRunnable(Socket s, String username, Scanner cin) throws IOException {
    this.socket = s;
    this.username = username;
    this.cin = cin;
    this.output = new PrintWriter(socket.getOutputStream(), true);
  }

  @Override
  public void run() {
    while (true) {
      String input = cin.nextLine();
      if (input.isEmpty()) {
        continue;
      }
      Pair<String, String> pair = format(input);
      Packet<Message> packet = new Packet<Message>(new Message(pair.getValue()), pair.getKey());
      output.println(SerializerFactory.getSerializer().serialize(packet));
    }
  }

  public Pair<String, String> format(String input) {
    input.trim();
    String[] split = input.split(" ", 2);
    return new Pair<String, String>(split[0], split[0] + " " + split[1] + " (" + username + ")");
  }
}
