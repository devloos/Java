package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class GameNotStarted extends Message {
    public GameNotStarted() {
        super(MessageType.GameNotStarted);
    }
}
