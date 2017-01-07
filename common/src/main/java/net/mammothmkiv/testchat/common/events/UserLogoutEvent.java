package net.mammothmkiv.testchat.common.events;

import net.mammothmkiv.testchat.common.UserDescriptor;

public class UserLogoutEvent {
    private UserDescriptor descriptor;

    public UserLogoutEvent(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public UserDescriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
