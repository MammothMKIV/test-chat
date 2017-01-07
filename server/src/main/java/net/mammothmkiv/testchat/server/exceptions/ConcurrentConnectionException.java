package net.mammothmkiv.testchat.server.exceptions;

public class ConcurrentConnectionException extends Exception {
    public ConcurrentConnectionException(String message) {
        super(message);
    }
}
