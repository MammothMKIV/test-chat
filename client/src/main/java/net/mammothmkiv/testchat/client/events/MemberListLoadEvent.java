package net.mammothmkiv.testchat.client.events;

import net.mammothmkiv.testchat.common.UserDescriptor;

import java.util.Hashtable;

/**
 * Created by n.rogovoy on 11/12/2015.
 */
public class MemberListLoadEvent {
    private Hashtable<String, UserDescriptor> members;

    public MemberListLoadEvent(Hashtable<String, UserDescriptor> members) {
        this.members = members;
    }

    public Hashtable<String, UserDescriptor> getMembers() {
        return members;
    }

    public void setMembers(Hashtable<String, UserDescriptor> members) {
        this.members = members;
    }
}
