package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.UserDescriptor;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class UserLoginNotificationPacket implements Serializable {
    private UserDescriptor descriptor;

    public UserLoginNotificationPacket(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public UserDescriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
