package net.mammothmkiv.testchat.client;

import com.google.common.eventbus.EventBus;

import java.io.ObjectInputStream;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class ServerDataReceiver extends Thread {
    private ConnectionInfo connectionInfo;
    private EventBus packetBus;

    public ServerDataReceiver(ConnectionInfo connectionInfo, EventBus packetBus) {
        this.connectionInfo = connectionInfo;
        this.packetBus = packetBus;
    }

    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(connectionInfo.connection.getInputStream());

            while (true) {
                Object obj = inputStream.readObject();

                packetBus.post(obj);
            }
        } catch (Exception e) {
            connectionInfo.isConnected = false;
            connectionInfo.isSignedIn = false;
        }
    }
}
