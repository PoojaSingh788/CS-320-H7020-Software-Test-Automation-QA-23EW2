package org.example;

import org.junit.internal.runners.statements.ExpectException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactTest {

//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    void tearDown() {
//    }

    @org.junit.jupiter.api.Test
    void isDigit() {
        assertTrue(Contact.isDigit('1'));
        assertTrue(Contact.isDigit('2'));
        assertTrue(Contact.isDigit('3'));
        assertTrue(Contact.isDigit('4'));
        assertTrue(Contact.isDigit('5'));
        assertTrue(Contact.isDigit('6'));
        assertTrue(Contact.isDigit('7'));
        assertTrue(Contact.isDigit('8'));
        assertTrue(Contact.isDigit('9'));
        assertTrue(Contact.isDigit('0'));
        assertFalse(Contact.isDigit('a'));
    }

    @org.junit.jupiter.api.Test
    void allDigits() {
        assertTrue(Contact.allDigits("1234"));
        assertFalse(Contact.allDigits("1234a"));
        assertFalse(Contact.allDigits(""));
    }

    @org.junit.jupiter.api.Test
    void createObjectTest() throws Exception {
        try {
            new Contact("", "Pooja", "Singh",
                    "1234567890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "UniqueId length is not correct");
        }

        try {
            new Contact("12345678901", "Pooja", "Singh",
                    "1234567890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "UniqueId length is not correct");
        }

        try {
            new Contact("1", "", "Singh",
                    "1234567890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "firstName length is not correct");
        }

        try {
            new Contact("1", "poojapoojapooja", "Singh",
                    "1234567890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "firstName length is not correct");
        }

        try {
            new Contact("1", "Pooja", "",
                    "1234567890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "lastName length is not correct");
        }

        try {
            new Contact("1", "Pooja", "SinghSinghSinghh",
                    "1234567890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "lastName length is not correct");
        }

        try {
            new Contact("1", "Pooja", "Singh",
                    "1237890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "phoneNumber length/digits is not correct");
        }

        try {
            new Contact("1", "Pooja", "Singh",
                    "12378901237890", "1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "phoneNumber length/digits is not correct");
        }

        try {
            new Contact("1", "Pooja", "Singh",
                    "1234567890", "");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "address length is not correct");
        }

        try {
            new Contact("1", "Pooja", "Singh",
                    "1234567890", "1234 abc blvd, rr, tx, 1234 abc blvd, rr, tx, 1234 abc blvd, rr, tx");
        } catch(Exception ex)
        {
            assertEquals(ex.getMessage(), "address length is not correct");
        }

        Contact contact = new Contact("1", "Pooja", "Singh",
                "1234567890", "1234 abc blvd, rr, tx");
        assertEquals(contact.getUniqueId(), "1");
        assertEquals(contact.getFirstName(), "Pooja");
        assertEquals(contact.getLastName(), "Singh");
        assertEquals(contact.getPhoneNumber(), "1234567890");
        assertEquals(contact.getAddress(),"1234 abc blvd, rr, tx");

    }
}