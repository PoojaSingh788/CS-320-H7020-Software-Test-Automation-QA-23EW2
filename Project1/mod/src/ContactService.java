package org.example;

import java.util.HashMap;
public class ContactService {
    private HashMap<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }
    public Contact addContact(Contact contact) {
        return contacts.put(contact.getUniqueId(), contact);
    }
    public Contact removeContact(String contactId) {
       return contacts.remove(contactId);
    }
    public Contact updateContactFirstName(String contactId, String firstName) throws Exception {
        Contact contact = contacts.get(contactId);
        if (contact == null)
            return null;
        contact.setFirstName(firstName);
        return contacts.put(contactId, contact);
    }

    public Contact updateContactLastName(String contactId, String LastName) throws Exception {
        Contact contact = contacts.get(contactId);
        if (contact == null)
            return null;
        contact.setLastName(LastName);
        return contacts.put(contactId, contact);
    }

    public Contact updateContactNumber(String contactId, String number) throws Exception {
        Contact contact = contacts.get(contactId);
        if (contact == null)
            return null;
        contact.setPhoneNumber(number);
        return contacts.put(contactId, contact);
    }

    public Contact updateContactAddress(String contactId, String address) throws Exception {
        Contact contact = contacts.get(contactId);
        if (contact == null)
            return null;
        contact.setAddress(address);
        return contacts.put(contactId, contact);
    }
    public Contact hasContact(String contactId) {
        return contacts.get(contactId);
    }

}
