package inputOutput;

public class ContactBookTest {
	public static void main(String[] args) throws ContactBookException {
		writeTestData();
		testPersistedData();
	}

	private static void writeTestData() throws ContactBookException {
		ContactBook book = new ContactBook();
		book.addContact("Hans Meier", "Bahnhofstrasse 123, 8001 Zürich");
		book.addNumber("Hans Meier", "043 43 222 11 33", "office");
		book.addNumber("Hans Meier", "079 78 123 45 6", "mobile");
		book.save();
	}

	private static void testPersistedData() throws ContactBookException {
		ContactBook book = new ContactBook();
		book.load();
		Contact contact = book.findContact("Hans Meier");
		boolean success = contact != null && contact.getName().equals("Hans Meier") &&
			contact.getAddress().equals("Bahnhofstrasse 123, 8001 Zürich") &&
			hasPhoneNumber(contact, "043 43 222 11 33", "office") &&
			hasPhoneNumber(contact, "079 78 123 45 6", "mobile");
		System.out.println("Test " + (success ? "ok" : "failed"));
	}
	
	private static boolean hasPhoneNumber(Contact contact, String number, String description) {
		for (PhoneEntry entry : contact.getPhoneEntries()) {
			if (entry.getNumber().equals(number) && entry.getDescription().equals(description)) {
				return true;
			}
		}
		return false;
	}
}
