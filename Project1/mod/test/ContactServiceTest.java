
import org.example.Contact;
import org.example.ContactService;

import static org.junit.jupiter.api.Assertions.assertTrue;
class ContactServiceTest {

//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    void tearDown() {
//    }

    @org.junit.jupiter.api.Test
    void addContact() throws Exception {
        Contact contact = new Contact("1", "Pooja", "Singh",
                "1234567890", "1234 abc blvd, rr, tx");
        ContactService contactService = new ContactService();
        contactService.addContact(contact);
        Contact contactFromService = contactService.hasContact(contact.getUniqueId());
        assertTrue(contactFromService.equals(contact));

        contact = new Contact("2", "Pooja", "Singh",
                "1234567890", "1234 abc blvd, rr, tx");
        contactService = new ContactService();
        contactService.addContact(contact);
        contactFromService = contactService.hasContact(contact.getUniqueId());
        assertTrue(contactFromService.equals(contact));

        contact = new Contact("1", "Pooja", "Singh",
                "1234567890", "1234 abc blvd, rr, tx");
        contactService = new ContactService();
        contactService.addContact(contact);
        contactFromService = contactService.hasContact(contact.getUniqueId());
        assertTrue(contactFromService.equals(contact));


    }

    @org.junit.jupiter.api.Test
    void removeContact() throws Exception {
        Contact contact = new Contact("1", "Pooja", "Singh",
                "1234567890", "1234 abc blvd, rr, tx");
        ContactService contactService = new ContactService();
        contactService.addContact(contact);
        Contact contactFromService = contactService.hasContact(contact.getUniqueId());
        assertTrue(contactFromService.equals(contact));

        contactService.removeContact(contact.getUniqueId());
        assertTrue(contactService.hasContact(contact.getUniqueId())==null);

        assertTrue(contactService.hasContact("10")==null);
    }

    @org.junit.jupiter.api.Test
    void updateContact() throws Exception {
        Contact contact = new Contact("1", "Pooja", "Singh",
                "1234567890", "1234 abc blvd, rr, tx");
        ContactService contactService = new ContactService();
        contactService.addContact(contact);
        Contact contactFromService = contactService.hasContact(contact.getUniqueId());
        assertTrue(contactFromService.equals(contact));

        contactService.updateContactFirstName(contact.getUniqueId(), "POOJA");
        contact = contactService.hasContact(contact.getUniqueId());
        assertTrue(contact.getFirstName().equals("POOJA"));

        contactService.updateContactLastName(contact.getUniqueId(), "SINGH");
        contact = contactService.hasContact(contact.getUniqueId());
        assertTrue(contact.getLastName().equals("SINGH"));

        contactService.updateContactNumber(contact.getUniqueId(), "0987654321");
        contact = contactService.hasContact(contact.getUniqueId());
        assertTrue(contact.getPhoneNumber().equals("0987654321"));

        contactService.updateContactAddress(contact.getUniqueId(), "1234 ABC BLVD, RR, TX");
        contact = contactService.hasContact(contact.getUniqueId());
        assertTrue(contact.getAddress().equals("1234 ABC BLVD, RR, TX"));

    }
}