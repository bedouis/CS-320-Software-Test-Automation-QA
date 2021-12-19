public class Contact {

	  private static final byte PHONE_NUMBER_LENGTH = 10;
	  private static final byte ID_LENGTH = 10;
	  private static final byte FIRST_NAME_LENGTH = 10;
	  private static final byte LAST_NAME_LENGTH = 10;
	  private static final byte ADDRESS_LENGTH = 30;
	  private static final String INITIAL_STRING = "INITIAL";
	  private static final String INITIAL_INT = "1234567890";
	  private String contactId;
	  private String firstName;
	  private String lastName;
	  private String phoneNumber;
	  private String address;

	  Contact() {
	    this.contactId = INITIAL_STRING;
	    this.firstName = INITIAL_STRING;
	    this.lastName = INITIAL_STRING;
	    this.phoneNumber = INITIAL_INT;
	    this.address = INITIAL_STRING;
	  }

	  Contact(String contactId) {
	    setContactId(contactId);
	    this.firstName = INITIAL_STRING;
	    this.lastName = INITIAL_STRING;
	    this.phoneNumber = INITIAL_INT;
	    this.address = INITIAL_STRING;
	  }

	  Contact(String contactId, String firstName) {
	    setContactId(contactId);
	    setFirstName(firstName);
	    this.lastName = INITIAL_STRING;
	    this.phoneNumber = INITIAL_INT;
	    this.address = INITIAL_STRING;
	  }

	  Contact(String contactId, String firstName, String lastName) {
	    setContactId(contactId);
	    setFirstName(firstName);
	    setLastName(lastName);
	    this.phoneNumber = INITIAL_INT;
	    this.address = INITIAL_STRING;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber) {
	    setContactId(contactId);
	    setFirstName(firstName);
	    setLastName(lastName);
	    setPhoneNumber(phoneNumber);
	    this.address = INITIAL_STRING;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber, String address) {
	    setContactId(contactId);
	    setFirstName(firstName);
	    setLastName(lastName);
	    setPhoneNumber(phoneNumber);
	    setAddress(address);
	  }

	  public final String getContactId() { 
		  return contactId; 
		  }

	  public final String getFirstName() { 
		  return firstName; }

	  public String getLastName() { return lastName; 
	  }

	  public String getPhoneNumber() { 
		  return phoneNumber; 
		  }

	  public String getAddress() { 
		  return address; 
		  }
	  
	  public final void setContactId(String contactId) {
		    if (contactId == null) {
		      throw new IllegalArgumentException("Contact ID cannot be empty");
		    } 
		    else if (contactId.length() > ID_LENGTH) {
		      throw new IllegalArgumentException("Contact ID cannot be longer than " +
		                                         ID_LENGTH + " characters");
		    } 
		    else {
		      this.contactId = contactId;
		    }
		  }

	  public void setFirstName(String firstName) {
	    if (firstName == null) {
	      throw new IllegalArgumentException("First name cannot be empty");
	    } 
	    else if (firstName.length() > FIRST_NAME_LENGTH) {
	      throw new IllegalArgumentException("First name cannot be longer than " +
	                                         FIRST_NAME_LENGTH + " characters");
	    } 
	    else {
	      this.firstName = firstName;
	    }
	  }

	  public void setLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Last name cannot be empty");
	    } 
	    else if (lastName.length() > LAST_NAME_LENGTH) {
	      throw new IllegalArgumentException("Last name cannot be longer than " +
	                                         LAST_NAME_LENGTH + " characters");
	    } 
	    else {
	      this.lastName = lastName;
	    }
	  }

	  public void setPhoneNumber(String phoneNumber) {
	    String regex = "[0-9]+";
	    if (phoneNumber == null) {
	      throw new IllegalArgumentException("Phone number cannot be empty.");
	    } 
	    else if (phoneNumber.length() != PHONE_NUMBER_LENGTH) {
	      throw new IllegalArgumentException(
	          "Phone number length invalid. Ensure it is " +
	          PHONE_NUMBER_LENGTH + " digits.");
	    } 
	    else if (!phoneNumber.matches(regex)) {
	      throw new IllegalArgumentException(
	          "Phone number cannot have anything but numbers");
	    } 
	    else {
	      this.phoneNumber = phoneNumber;
	    }
	  }

	  public void setAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Address cannot be empty");
	    } 
	    else if (address.length() > ADDRESS_LENGTH) {
	      throw new IllegalArgumentException("Address cannot be longer than " +
	                                         ADDRESS_LENGTH +
	                                         " characters");
	    } 
	    else {
	      this.address = address;
	    }
	  }
	}