package net.mammothmkiv.testchat.common;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class UserDescriptor implements Serializable {
    public String id;
    public String nickname;

    public UserDescriptor(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
