import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

  private String uniqueContactId;
  private List<Contact> contactList = new ArrayList<>();
  
  private String newUniqueContactId() {
    uniqueContactId = UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
    return uniqueContactId;
  }

  public void newContact() {
    Contact contact = new Contact(newUniqueContactId());
    contactList.add(contact);
  }

  public void newContact(String firstName) {
    Contact contact = new Contact(newUniqueContactId(), firstName);
    contactList.add(contact);
  }

  public void newContact(String firstName, String lastName) {
    Contact contact = new Contact(newUniqueContactId(), firstName, lastName);
    contactList.add(contact);
  }

  public void newContact(String firstName, String lastName,
                         String phoneNumber) {
    Contact contact =
        new Contact(newUniqueContactId(), firstName, lastName, phoneNumber);
    contactList.add(contact);
  }

  public void newContact(String firstName, String lastName, String phoneNumber,
                         String address) {
    Contact contact =
        new Contact(newUniqueContactId(), firstName, lastName, phoneNumber, address);
    contactList.add(contact);
  }

  public void deleteContact(String contactId) throws Exception {
    contactList.remove(searchContact(contactId));
  }

  public void updateFirstName(String contactId, String firstName) throws Exception {
    searchContact(contactId).setFirstName(firstName);
  }

  public void updateLastName(String contactId, String lastName) throws Exception {
    searchContact(contactId).setLastName(lastName);
  }

  public void updatePhoneNumber(String contactId, String phoneNumber)
      throws Exception {
    searchContact(contactId).setPhoneNumber(phoneNumber);
  }

  public void updateAddress(String contactId, String address) throws Exception {
    searchContact(contactId).setAddress(address);
  }

  protected List<Contact> getContactList() { 
	  return contactList; 
	  }

  
  private Contact searchContact(String contactId) throws Exception {
    for (int i = 0; i < contactList.size(); i++) {
      if (contactId.equals(contactList.get(i).getContactId())) {
        return contactList.get(i);
      }
    }
    throw new Exception("The contact does not exist");
  }
}