package com.edu.Main.serialize;

// singleton implementation of the Serializer
public class SerializerFactory {
    private static Serializer serializer;

    public static Serializer getSerializer() {
        if (serializer == null) {
            serializer = new Serializer();
        }
        return serializer;
    }
}
