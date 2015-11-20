package net.mammothmkiv.testchat.server;

public class ChatServer {

    private static ServerConnectionListener connectionListener;

    public static void main(String[] args) {
        connectionListener = new ServerConnectionListener();
        ServerPacketBus.getInstance().register(new ClientPacketHandler());
        ServerEventBus.getInstance().register(new ServerEventHandler());
        connectionListener.start();
    }
}
