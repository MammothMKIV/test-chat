package net.mammothmkiv.testchat.common;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class UserLoginEvent {
    public UserDescriptor descriptor;

    public UserLoginEvent(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
