package net.mammothmkiv.testchat.common;

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
