package net.mammothmkiv.testchat.server.authenticators;

import net.mammothmkiv.testchat.common.AuthenticationCredentials;

/**
 * Created by n.rogovoy on 11/11/2015.
 */
public interface IAuthenticator {
    public Boolean authenticate(AuthenticationCredentials credentials);
}
