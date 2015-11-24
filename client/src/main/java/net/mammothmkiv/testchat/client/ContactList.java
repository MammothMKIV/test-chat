package net.mammothmkiv.testchat.client;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import net.mammothmkiv.testchat.client.events.ContactListUpdateEvent;
import net.mammothmkiv.testchat.client.events.MemberListLoadEvent;
import net.mammothmkiv.testchat.common.UserDescriptor;
import net.mammothmkiv.testchat.common.events.UserLoginEvent;
import net.mammothmkiv.testchat.common.events.UserLogoutEvent;

import java.util.Hashtable;

/**
 * Created by n.rogovoy on 11/13/2015.
 */
public class ContactList {
    private Hashtable<String, UserDescriptor> contacts = new Hashtable<>();
    private EventBus chatBus;

    public ContactList(EventBus chatBus) {
        this.chatBus = chatBus;
    }

    private void doNotify() {
        chatBus.post(new ContactListUpdateEvent(this));
    }

    public Hashtable<String, UserDescriptor> getContacts() {
        return contacts;
    }

    @Subscribe public void handleUserLoginEvent(UserLoginEvent e) {
        contacts.put(e.getDescriptor().getId(), e.getDescriptor());
        doNotify();
    }

    @Subscribe public void handleUserLogoutEvent(UserLogoutEvent e) {
        contacts.remove(e.getDescriptor().getId());
        doNotify();
    }

    @Subscribe public void handleMemberListLoadEvent(MemberListLoadEvent e) {
        contacts = e.members;
        doNotify();
    }
}
