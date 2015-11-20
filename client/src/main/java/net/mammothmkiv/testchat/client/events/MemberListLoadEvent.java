package net.mammothmkiv.testchat.client.events;

import net.mammothmkiv.testchat.common.UserDescriptor;

import java.util.Hashtable;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class MemberListLoadEvent {
    public Hashtable<String, UserDescriptor> members;

    public MemberListLoadEvent(Hashtable<String, UserDescriptor> members) {
        this.members = members;
    }
}
