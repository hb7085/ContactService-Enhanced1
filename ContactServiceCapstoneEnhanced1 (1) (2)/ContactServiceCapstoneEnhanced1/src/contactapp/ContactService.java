package contactapp;

import java.util.ArrayList;

import contactapp.IdGenerator;

import java.util.logging.Logger;

/**
 * Service class responsible for managing Contact objects.
 * Provides operations for creating, updating, and deleting contacts.
 * Uses logging to track all operations for debugging and maintainability.
 */
public class ContactService {
	private static final Logger logger = Logger.getLogger(ContactService.class.getName());
	/** Stores all contacts currently managed by the service. */
    private ArrayList<Contact> contacts = new ArrayList<>();
   
    /**
     * Creates a new Contact with a generated unique ID and adds it to the list.
     *
     * @param firstName the contact's first name
     * @param lastName the contact's last name
     * @param phone the contact's phone number (must be 10 digits)
     * @param address the contact's address
     */
    public void addContact(String firstName, String lastName, String phone, String address) {
    	String id = IdGenerator.generateId();
    	logger.info("Creating new contact with ID: " + id);
    	
        Contact newContact = new Contact(id, firstName, lastName, phone, address);
        contacts.add(newContact);
        
        logger.info("Contact added successfully: " + id);
    }
    /**
     * Deletes a contact that matches the given ID.
     * Logs whether the deletion was successful or if the ID was not found.
     *
     * @param contactId the ID of the contact to delete
     */
    public void deleteContact(String contactId) {
    	logger.info("Attempting to delete contact with ID: " + contactId);
    	
    	boolean removed = contacts.removeIf(c -> c.getContactId().equals(contactId));

        if (removed) {
            logger.info("Contact deleted: " + contactId);
        } else {
            logger.warning("Delete failed — no contact found with ID: " + contactId);
        }
    }
    /**
     * Updates the first name of the contact with the given ID.
     * Logs success or failure if the ID does not exist.
     *
     * @param contactId the ID of the contact to update
     * @param firstName the new first name
     */
    public void updateFirstName(String contactId, String firstName) {
        logger.info("Updating first name for contact ID: " + contactId);

        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setFirstName(firstName);
                logger.info("First name updated for contact ID: " + contactId);
                return;
            }
        }

        logger.warning("Update failed — no contact found with ID: " + contactId);
    }
    /**
     * Updates the last name of the contact with the given ID.
     * Logs success or failure if the ID does not exist.
     *
     * @param contactId the ID of the contact to update
     * @param lastName the new last name
     */
    public void updateLastName(String contactId, String lastName) {
        logger.info("Updating last name for contact ID: " + contactId);

        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setLastName(lastName);
                logger.info("Last name updated for contact ID: " + contactId);
                return;
            }
        }

        logger.warning("Update failed — no contact found with ID: " + contactId);
    }
    /**
     * Updates the phone number of the contact with the given ID.
     * Logs success or failure if the ID does not exist.
     *
     * @param contactId the ID of the contact to update
     * @param phone the new phone number (must be 10 digits)
     */
    public void updatePhone(String contactId, String phone) {
        logger.info("Updating phone number for contact ID: " + contactId);

        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setPhone(phone);
                logger.info("Phone number updated for contact ID: " + contactId);
                return;
            }
        }

        logger.warning("Update failed — no contact found with ID: " + contactId);
    }
    /**
     * Updates the address of the contact with the given ID.
     * Logs success or failure if the ID does not exist.
     *
     * @param contactId the ID of the contact to update
     * @param address the new address
     */
    public void updateAddress(String contactId, String address) {
        logger.info("Updating address for contact ID: " + contactId);

        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setAddress(address);
                logger.info("Address updated for contact ID: " + contactId);
                return;
            }
        }

        logger.warning("Update failed — no contact found with ID: " + contactId);
    }
    /**
     * Returns the full list of contacts currently stored in memory.
     *
     * @return an ArrayList containing all Contact objects
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
