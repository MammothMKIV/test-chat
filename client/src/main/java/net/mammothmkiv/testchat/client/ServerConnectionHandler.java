package net.mammothmkiv.testchat.client;

import com.google.common.eventbus.EventBus;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class ServerConnectionHandler {
    private ServerDataReceiver dataReceiver;
    private ConnectionInfo connectionInfo = new ConnectionInfo();
    private ObjectOutputStream outputStream;
    private EventBus packetBus;

    public ServerConnectionHandler() {
        packetBus = new EventBus();
    }

    public void send(Object data) throws IOException {
        outputStream.writeObject(data);
    }

    public void connect() throws IOException {
        if (!isConnected()) {
            connectionInfo.connection = new Socket("127.0.0.1", 25565);
            connectionInfo.isConnected = true;
            outputStream = new ObjectOutputStream(connectionInfo.connection.getOutputStream());
            dataReceiver = new ServerDataReceiver(connectionInfo, packetBus);
            dataReceiver.setDaemon(true);
            dataReceiver.start();
        }
    }

    public void registerPacketHandler(Object obj) {
        packetBus.register(obj);
    }

    private Boolean isConnected() {
        return connectionInfo.isConnected;
    }
}
