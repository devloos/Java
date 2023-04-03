package com.edu.Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.Received;
import com.edu.Main.messages.client.CreateGame;
import com.edu.Main.messages.client.JoinGame;
import com.edu.Main.messages.client.PlayerInfoChanged;
import com.edu.Main.messages.client.PlayerInfoConfirmed;
import com.edu.Main.messages.client.PlayerReady;
import com.edu.Main.messages.client.SubscribeGameList;
import com.edu.Main.messages.server.AvatarSelectionStarted;
import com.edu.Main.messages.server.GameCreated;
import com.edu.Main.messages.server.GameJoined;
import com.edu.Main.messages.server.GameList;
import com.edu.Main.messages.server.GameStarted;
import com.edu.Main.messages.server.PlayerJoined;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) throws Exception {
        println(GREEN, "User 1: SubscribeGameList -> Server");
        Message message = new SubscribeGameList();
        prettyPrint(message);

        sleepPrint(1000);

        ArrayList<Integer> lobbyIds = new ArrayList<Integer>();
        println(GREEN, "Server: GameList -> User 1");
        message = new GameList(lobbyIds);
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "User 1: CreateGame -> Server");
        message = new CreateGame("ChunLILover");
        prettyPrint(message);

        sleepPrint(1000);

        lobbyIds.add(1032);
        println(GREEN, "Server: GameCreated -> User 1");
        message = new GameCreated(1032);
        prettyPrint(message);

        sleepPrint(3000);

        println(GREEN, "User 2: SubscribeGameList -> Server");
        message = new SubscribeGameList();
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: GameList -> User 2");
        message = new GameList(lobbyIds);
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "User 2: JoinGame -> Server");
        message = new JoinGame("BisonLover", 1032);
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: GameJoined -> User 2");
        message = new GameJoined("ChunLILover");
        prettyPrint(message);
        println(GREEN, "Server: PlayerJoined -> User 1");
        message = new PlayerJoined("BisonLover");
        prettyPrint(message);

        sleepPrint(3000);

        println(GREEN, "User 2: PlayerReady -> Server");
        message = new PlayerReady();
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "User 1: PlayerReady -> Server");
        message = new PlayerReady();
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: AvatarSelectionStarted -> User 1");
        message = new AvatarSelectionStarted("BisonLover");
        prettyPrint(message);
        println(GREEN, "Server: AvatarSelectionStarted -> User 2");
        message = new AvatarSelectionStarted("ChunLILover");
        prettyPrint(message);

        sleepPrint(2000);

        println(GREEN, "User 2: PlayerInfoChanged -> Server");
        message = new PlayerInfoChanged("Bison");
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: Received -> User 2");
        message = new Received(true);
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "User 2: PlayerInfoChanged -> Server");
        message = new PlayerInfoChanged("Chun-Li");
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: Received -> User 2");
        message = new Received(true);
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "User 2: PlayerInfoConfirmed -> Server");
        message = new PlayerInfoConfirmed("BisonLover", "Chun-Li");
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: Received -> User 2");
        message = new Received(true);
        prettyPrint(message);

        sleepPrint(3000);

        println(GREEN, "User 1: PlayerInfoChanged -> Server");
        message = new PlayerInfoChanged("Ryu");
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: Received -> User 1");
        message = new Received(true);
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "User 1: PlayerInfoConfirmed -> Server");
        message = new PlayerInfoConfirmed("ChunLILover", "Ryu");
        prettyPrint(message);

        sleepPrint(1000);

        println(GREEN, "Server: GameStarted -> User 1");
        message = new GameStarted();
        prettyPrint(message);
        println(GREEN, "Server: GameStarted -> User 2");
        message = new GameStarted();
        prettyPrint(message);
    }

    static public void serialize(Object obj) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.ser"));
        out.writeObject(obj);
        out.close();
    }

    static public Message deserialize() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.ser"));
        Message message = (Message) in.readObject();
        in.close();
        return message;
    }

    static public void prettyPrint(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(YELLOW + gson.toJson(obj) + RESET);
    }

    static public void sleepPrint(long milli) throws Exception {
        System.out.println(BLUE + "\nTime Elapsed: " + milli + " milliseconds\n" +
                RESET);
    }

    static void println(String color, String message) {
        System.out.println(color + message + RESET);
    }
}
