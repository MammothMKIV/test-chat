package net.mammothmkiv.testchat.server;

import com.google.common.eventbus.EventBus;

public class ServerEventBus extends EventBus {
    private static ServerEventBus instance = new ServerEventBus();

    private ServerEventBus() {
        super();
    }

    public static ServerEventBus getInstance() {
        return instance;
    }
}
