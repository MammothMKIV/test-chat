package net.mammothmkiv.testchat.server.authenticators;

public class AuthenticationException extends Exception {
    AuthenticationException(String message) {
        super(message);
    }
}
