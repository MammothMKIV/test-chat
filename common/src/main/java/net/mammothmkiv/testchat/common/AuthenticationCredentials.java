package net.mammothmkiv.testchat.common;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class AuthenticationCredentials {
    private String nickname;

    public AuthenticationCredentials(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
