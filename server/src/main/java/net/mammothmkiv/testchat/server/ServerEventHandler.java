package net.mammothmkiv.testchat.server;

import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.common.events.UserLoginEvent;
import net.mammothmkiv.testchat.common.events.UserLogoutEvent;
import net.mammothmkiv.testchat.common.events.UserMessageEvent;
import net.mammothmkiv.testchat.common.packets.UserLoginNotificationPacket;
import net.mammothmkiv.testchat.common.packets.UserLogoutNotificationPacket;
import net.mammothmkiv.testchat.common.packets.UserMessagePacket;

import java.io.IOException;

public class ServerEventHandler {

    @Subscribe public void handleUserLoginEvent(UserLoginEvent e) {
        ActiveUserRegistry.getInstance().getActiveUsers().forEach((id, connection) -> {
            if (!connection.getId().equals(e.getDescriptor().getId())) {
                try {
                    connection.getClientHandler().send(new UserLoginNotificationPacket(e.getDescriptor()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    @Subscribe public void handleUserLogoutEvent(UserLogoutEvent e) {
        ActiveUserRegistry.getInstance().getActiveUsers().forEach((id, connection) -> {
            try {
                connection.getClientHandler().send(new UserLogoutNotificationPacket(e.getDescriptor()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @Subscribe public void handleUserMessageEvent(UserMessageEvent e) {
        ActiveUserRegistry.getInstance().getActiveUsers().forEach((id, connection) -> {
            try {
                connection.getClientHandler().send(new UserMessagePacket(e.getMessage()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
