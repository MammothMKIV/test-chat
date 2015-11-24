package net.mammothmkiv.testchat.common.packets;

import java.io.Serializable;

/**
 * Created by n.rogovoy on 11/10/2015.
 */
public class LoginRequestPacket implements Serializable {
    private String nickname;

    public LoginRequestPacket(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
