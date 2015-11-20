package net.mammothmkiv.testchat.client.events;

import net.mammothmkiv.testchat.common.UserDescriptor;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class LoginSuccessEvent {
    public UserDescriptor descriptor;

    public LoginSuccessEvent(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
