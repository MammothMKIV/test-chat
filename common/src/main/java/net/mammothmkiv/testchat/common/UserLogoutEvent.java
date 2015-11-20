package net.mammothmkiv.testchat.common;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class UserLogoutEvent {
    public UserDescriptor descriptor;

    public UserLogoutEvent(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}
