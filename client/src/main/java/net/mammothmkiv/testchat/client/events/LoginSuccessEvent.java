package net.mammothmkiv.testchat.client.events;

import net.mammothmkiv.testchat.common.UserDescriptor;

public class LoginSuccessEvent {
    private UserDescriptor descriptor;

    public LoginSuccessEvent(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public UserDescriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
