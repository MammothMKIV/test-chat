package net.mammothmkiv.testchat.client.events;

import net.mammothmkiv.testchat.client.ContactList;

/**
 * Created by n.rogovoy on 11/13/2015.
 */
public class ContactListUpdateEvent {
    private ContactList contactList;

    public ContactListUpdateEvent(ContactList contactList) {
        this.contactList = contactList;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }
}
