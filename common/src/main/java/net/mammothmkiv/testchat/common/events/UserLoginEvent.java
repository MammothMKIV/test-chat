package net.mammothmkiv.testchat.common.events;

import net.mammothmkiv.testchat.common.UserDescriptor;

public class UserLoginEvent {
    private UserDescriptor descriptor;

    public UserLoginEvent(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public UserDescriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
