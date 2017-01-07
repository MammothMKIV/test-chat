package net.mammothmkiv.testchat.client.events;

public class LoginFailedEvent {
    private String message;

    public LoginFailedEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
