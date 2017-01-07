package net.mammothmkiv.testchat.common.packets;

import net.mammothmkiv.testchat.common.UserDescriptor;

import java.io.Serializable;

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
