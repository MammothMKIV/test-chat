package net.mammothmkiv.testchat.client;

import com.google.common.eventbus.EventBus;

import java.io.ObjectInputStream;

public class ServerDataReceiver extends Thread {
    private ConnectionInfo connectionInfo;
    private EventBus packetBus;

    public ServerDataReceiver(ConnectionInfo connectionInfo, EventBus packetBus) {
        this.connectionInfo = connectionInfo;
        this.packetBus = packetBus;
    }

    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(connectionInfo.getConnection().getInputStream());

            while (true) {
                Object obj = inputStream.readObject();

                packetBus.post(obj);
            }
        } catch (Exception e) {
            connectionInfo.setConnected(false);
            connectionInfo.setSignedIn(false);
        }
    }
}
