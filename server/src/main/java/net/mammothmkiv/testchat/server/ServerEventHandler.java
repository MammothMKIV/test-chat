package net.mammothmkiv.testchat.server;

import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.common.*;

import java.io.IOException;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class ServerEventHandler {

    @Subscribe public void handleUserLoginEvent(UserLoginEvent e) {
        ActiveUserRegistry.getInstance().getActiveUsers().forEach((id, connection) -> {
            if (!connection.id.equals(e.descriptor.id)) {
                try {
                    connection.clientHandler.send(new UserLoginNotificationPacket(e.descriptor));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    @Subscribe public void handleUserLogoutEvent(UserLogoutEvent e) {
        ActiveUserRegistry.getInstance().getActiveUsers().forEach((id, connection) -> {
            try {
                connection.clientHandler.send(new UserLogoutNotificationPacket(e.descriptor));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @Subscribe public void handleUserMessageEvent(UserMessageEvent e) {
        ActiveUserRegistry.getInstance().getActiveUsers().forEach((id, connection) -> {
            try {
                connection.clientHandler.send(new UserMessagePacket(e.message));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
