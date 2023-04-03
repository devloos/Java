package com.edu.Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        // // server
        // GameMessage message = new GameMessage("Hello from the game", "devlos");

        // ObjectOutputStream out = new ObjectOutputStream(new
        // FileOutputStream("file.ser"));
        // out.writeObject(message);
        // out.close();

        // // client
        // ObjectInputStream in = new ObjectInputStream(new
        // FileInputStream("file.ser"));
        // // never get an error here
        // Message m = (Message) in.readObject();
        // String type = m.type;
        // if (type.equals("GameMessage")) {
        // GameMessage g = (GameMessage) m;
        // System.out.println(g.message + " " + g.user_id);
        // } else if (type.equals("AvatarMessage")) {
        // AvatarMessage a = (AvatarMessage) m;
        // System.out.println(a.alert + " " + a.alert_code);
        // } else {
        // System.out.println(type instanceof String);
        // }
        // in.close();
    }
}