package com.edu.Main.serialize;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.Subscribe;

// singleton implementation of the Serializer
public class SerializerFactory {
    private static Serializer serializer = null;

    public static Serializer getSerializer() {
        if (serializer == null) {
            serializer = new Serializer();
        }
        return serializer;
    }
}
