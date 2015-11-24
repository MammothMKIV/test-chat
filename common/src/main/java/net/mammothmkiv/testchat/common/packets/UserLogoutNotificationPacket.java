package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.UserDescriptor;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class UserLogoutNotificationPacket implements Serializable {
    public UserDescriptor descriptor;

    public UserLogoutNotificationPacket(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
