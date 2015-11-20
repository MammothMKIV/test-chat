package net.mammothmkiv.testchat.server.exceptions;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public class IncorrectPacketSequenceException extends Exception {
    public IncorrectPacketSequenceException(String message) {
        super(message);
    }
}
