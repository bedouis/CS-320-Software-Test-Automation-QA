
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void setUp() {
    contactId = "W3QA0IYSJB";
    firstNameTest = "John";
    lastNameTest = "Doe";
    phoneNumberTest = "2224448888";
    addressTest = "4 John Doe Street SF CA, 94102";
    tooLongContactId = "112233445566778899";
    tooLongFirstName = "Charles-Henry";
    tooLongLastName = "De La Maisonneuve";
    tooLongPhoneNumber = "33355599990";
    tooShortPhoneNumber = "111777666";
    tooLongAddress = "444 John Doe Street San Francisco CA, 94102";
  }

  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("Default Constructor",
              ()
                  -> assertNotNull(contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              ()  
              	  -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(contactId);
    assertAll("ID constructor",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactFirstNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("First Name Constructor",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactLastNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("Last Name Constructor",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactPhoneNumberConstructorTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("Phone number Constructor",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactAddressConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    assertAll("Address Constructor",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }
  
  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
    contact.setContactId(contactId);
    assertAll(
        "contact ID",
        ()
            -> assertEquals(contactId, contact.getContactId()),
        ()
            -> assertThrows(IllegalArgumentException.class, () -> contact.setContactId(null)),
        ()
            -> assertThrows(IllegalArgumentException.class, () -> contact.setContactId(tooLongContactId)));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.setFirstName(firstNameTest);
    assertAll(
        "first name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(tooLongFirstName)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.setLastName(lastNameTest);
    assertAll(
        "last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName(tooLongLastName)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.setPhoneNumber(phoneNumberTest);
    assertAll("phone number",
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class, () -> contact.setPhoneNumber(tooLongPhoneNumber)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class, () -> contact.setPhoneNumber(tooShortPhoneNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(contactId)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.setAddress(addressTest);
    assertAll("address",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(tooLongAddress)));
  }

}