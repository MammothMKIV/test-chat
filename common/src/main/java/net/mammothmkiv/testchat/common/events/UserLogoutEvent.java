package net.mammothmkiv.testchat.common.events;

import net.mammothmkiv.testchat.common.UserDescriptor;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class UserLogoutEvent {
    public UserDescriptor descriptor;

    public UserLogoutEvent(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }
}