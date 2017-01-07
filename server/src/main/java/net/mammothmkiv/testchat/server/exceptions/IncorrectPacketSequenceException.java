package net.mammothmkiv.testchat.server.exceptions;

public class IncorrectPacketSequenceException extends Exception {
    public IncorrectPacketSequenceException(String message) {
        super(message);
    }
}
