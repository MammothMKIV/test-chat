package net.mammothmkiv.testchat.client;

import com.google.common.eventbus.EventBus;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
            connectionInfo.setConnection(new Socket("127.0.0.1", 25565));
            connectionInfo.setConnected(true);
            outputStream = new ObjectOutputStream(connectionInfo.getConnection().getOutputStream());
            dataReceiver = new ServerDataReceiver(connectionInfo, packetBus);
            dataReceiver.setDaemon(true);
            dataReceiver.start();
        }
    }

    public void registerPacketHandler(Object obj) {
        packetBus.register(obj);
    }

    private Boolean isConnected() {
        return connectionInfo.getConnected();
    }
}
