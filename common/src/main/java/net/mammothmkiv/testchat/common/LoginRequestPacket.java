package net.mammothmkiv.testchat.common;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/10/2015.
 */
public class LoginRequestPacket implements Serializable {
    public String nickname;

    public LoginRequestPacket(String nickname) {
        this.nickname = nickname;
    }
}
