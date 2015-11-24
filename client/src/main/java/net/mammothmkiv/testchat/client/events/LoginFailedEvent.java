package net.mammothmkiv.testchat.client.events;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
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
