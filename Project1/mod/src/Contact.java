package org.example;

import java.util.Objects;

public class Contact {
//    public Contact() {
//        uniqueId = null;
//        firstName = null;
//        lastName = null;
//        phoneNumber = null;
//        address = null;
//    }
    public Contact(String uniqueId, String firstName, String lastName, String phoneNumber, String address) throws Exception {
        setUniqueId(uniqueId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    public static boolean isDigit (char ch){
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }
    public static boolean allDigits(String s) {
        if (s.length()== 0)
            return false;

        for (int i=0; i < s.length(); i++) {
            if (!isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setUniqueId(String uniqueId) throws Exception {
        if (uniqueId.length() == 0 || uniqueId.length() > 10)
            throw new Exception("UniqueId length is not correct");
        this.uniqueId = uniqueId;
    }

    public void setFirstName(String firstName) throws Exception {
        if (firstName.length() == 0 || firstName.length() > 10)
            throw new Exception("firstName length is not correct");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws Exception {
        if (lastName.length() == 0 || lastName.length() > 10)
            throw new Exception("lastName length is not correct");
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber.length() == 0 || phoneNumber.length() > 10 || !allDigits(phoneNumber))
            throw new Exception("phoneNumber length/digits is not correct");
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) throws Exception {
        if (address.length() == 0 || address.length() > 30)
            throw new Exception("address length is not correct");
        this.address = address;
    }

    private String uniqueId;
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getUniqueId(), contact.getUniqueId()) && Objects.equals(getFirstName(), contact.getFirstName()) && Objects.equals(getLastName(), contact.getLastName()) && Objects.equals(getPhoneNumber(), contact.getPhoneNumber()) && Objects.equals(getAddress(), contact.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqueId(), getFirstName(), getLastName(), getPhoneNumber(), getAddress());
    }

    private String phoneNumber;
    private String address;
}
