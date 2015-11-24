package net.mammothmkiv.testchat.common;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class UserDescriptor implements Serializable {
    private String id;
    private String nickname;

    public UserDescriptor(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
