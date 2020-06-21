package inputOutput;

import java.util.HashMap;
import java.util.Map;

public class ContactBook {
	private Map<String, Contact> contactBook = new HashMap<>();

	public void load() throws ContactBookException {
		// TODO: Implement
	}

	public void save() throws ContactBookException {
		// TODO: Implement
	}

	public void addContact(String name, String address) {
		if (contactBook.containsKey(name)) {
			throw new IllegalArgumentException("Name already exists");
		}
		contactBook.put(name, new Contact(name, address));
	}

	public void addNumber(String name, String number, String description) {
		if (!contactBook.containsKey(name)) {
			throw new IllegalArgumentException("Name does not exist");
		}
		Contact contact = contactBook.get(name);
		contact.addPhoneEntry(new PhoneEntry(number, description));
	}

	public Contact findContact(String name) {
		return contactBook.get(name);
	}
}