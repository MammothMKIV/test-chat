package net.mammothmkiv.testchat.server.exceptions;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class ConcurrentConnectionException extends Exception {
    public ConcurrentConnectionException(String message) {
        super(message);
    }
}
