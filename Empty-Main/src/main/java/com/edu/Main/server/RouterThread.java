package com.edu.Main.server;

import java.util.ArrayList;
import java.util.HashMap;

import com.edu.Main.messages.*;
import com.edu.Main.messages.client.*;
import com.edu.Main.serialize.SerializerFactory;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Server Thread processing each connected client
 */
@NoArgsConstructor
@AllArgsConstructor
public class RouterThread extends Thread {

  private ArrayList<Pair<ServerThread, Packet<Message>>> jobs = new ArrayList<>();
  private HashMap<String, ArrayList<ServerThread>> map = new HashMap<String, ArrayList<ServerThread>>();

  @Override
  public void run() {
    while (true) {
      if (jobs.isEmpty()) {
        continue;
      }

      ServerThread thread = jobs.get(0).getKey();
      Packet<Message> packet = jobs.get(0).getValue();
      Message message = packet.getMessage();
      String channel = packet.getChannel();

      if (message.getType() == MessageType.Subscribe) {
        Subscribe subscribe = (Subscribe) message;
        for (String c : subscribe.getChannels()) {
          if (map.get(c) == null) {
            map.put(c, new ArrayList<ServerThread>());
          }
          map.get(c).add(thread);
        }

        deleteJob();
        continue;
      }

      if (map.get(channel) == null) {
        map.put(channel, new ArrayList<ServerThread>());
      }

      ArrayList<ServerThread> list = map.get(channel);

      for (ServerThread t : list) {
        Packet<Received> rp = new Packet<Received>(new Received(true), channel);
        t.getOutput().println(SerializerFactory.getSerializer().serialize(rp));
      }
    }
  }

  public synchronized void addJob(Pair<ServerThread, Packet<Message>> pair) {
    jobs.add(pair);
  }

  private synchronized void deleteJob() {
    jobs.remove(0);
  }
}
