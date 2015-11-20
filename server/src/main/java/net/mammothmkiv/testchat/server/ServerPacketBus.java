package net.mammothmkiv.testchat.server;

import com.google.common.eventbus.EventBus;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class ServerPacketBus extends EventBus {
    private static ServerPacketBus instance = new ServerPacketBus();

    private ServerPacketBus() {
        super();
    }

    public static ServerPacketBus getInstance() {
        return instance;
    }
}
