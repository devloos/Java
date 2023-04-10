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

    public static void main(String[] args) throws InterruptedException {
        try (Socket socket = new Socket(host, port)) {
            // return the output to the server : true statement is to flush the buffer
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner cin = new Scanner(System.in);
            ArrayList<String> channels = new ArrayList<>();
            System.out.println("What channels would you like to subscribe to? (Enter \"done\" when completed)");
            String channel = "done";
            while (true) {
                channel = cin.nextLine();
                if (channel.equals("done")) {
                    break;
                }
                channels.add(channel);
            }

            Subscribe sub = new Subscribe(channels);

            Packet<Subscribe> p = new Packet<Subscribe>(sub, "/" + socket.toString());
            output.println(SerializerFactory.getSerializer().serialize(p));

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

                System.out.println("\n" + message.getMessage() + "\n");
                System.out.print("Would you like to reply? [channel/n]: ");

                channel = cin.next();
                cin.nextLine();
                if (channel.toLowerCase().equals("n")) {
                    continue;
                }

                System.out.print("REPLY: ");
                m = cin.nextLine();
                message = new Message(m);
                packet = new Packet<Message>(message, channel);
                output.println(SerializerFactory.getSerializer().serialize(packet));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
