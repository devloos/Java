package com.edu.Main.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.edu.Main.messages.*;
import com.edu.Main.serialize.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static final int port = 8000;
    public static final String host = "localhost";

    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) throws InterruptedException {
        try (Socket socket = new Socket(host, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner cin = new Scanner(System.in);
            String username = getUsername(cin);

            ArrayList<String> channels = new ArrayList<>();
            setChannels(channels, cin);
            sendSubscription(channels, socket, username);

            Thread clientThread = new Thread(new ClientRunnable(socket, username, cin));
            clientThread.start();

            while (true) {
                String m = input.readLine();

                if (m == null) {
                    continue;
                }

                Packet<Message> packet = SerializerFactory.getSerializer().deserialize(m);

                if (packet == null) {
                    continue;
                }

                Message message = packet.getMessage();

                System.out.println(BLUE + message.getMessage() + RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getUsername(Scanner cin) {
        System.out.print("Enter username: ");
        return cin.nextLine();
    }

    public static void setChannels(ArrayList<String> channels, Scanner cin) {
        System.out.println("What channels would you like to subscribe to? (Enter \"done\" when completed)");
        String channel = "done";
        while (true) {
            channel = cin.nextLine();
            if (channel.equals("done")) {
                break;
            }
            channels.add(channel);
        }

        System.out.println();
    }

    public static void sendSubscription(ArrayList<String> channels, Socket socket, String username) throws IOException {
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Subscribe message = new Subscribe(channels, username);
        Packet<Subscribe> packet = new Packet<Subscribe>(message, "/" + socket.toString());
        output.println(SerializerFactory.getSerializer().serialize(packet));
    }
}
