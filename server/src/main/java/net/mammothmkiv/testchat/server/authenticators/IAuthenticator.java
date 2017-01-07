package net.mammothmkiv.testchat.server.authenticators;

import net.mammothmkiv.testchat.common.AuthenticationCredentials;

public interface IAuthenticator {
    void authenticate(AuthenticationCredentials credentials) throws AuthenticationException;
}
