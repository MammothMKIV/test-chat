package net.mammothmkiv.testchat.server;

import com.google.common.eventbus.EventBus;

public class ServerPacketBus extends EventBus {
    private static ServerPacketBus instance = new ServerPacketBus();

    private ServerPacketBus() {
        super();
    }

    public static ServerPacketBus getInstance() {
        return instance;
    }
}
