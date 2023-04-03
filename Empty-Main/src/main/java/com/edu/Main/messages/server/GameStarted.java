package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class GameStarted extends Message {
    public GameStarted() {
        super(MessageType.GameStarted);
    }
}
