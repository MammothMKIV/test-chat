package net.mammothmkiv.testchat.common;

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
