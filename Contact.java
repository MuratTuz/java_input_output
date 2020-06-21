package inputOutput;

import java.util.Collection;
import java.util.HashSet;

public class Contact {
	private String name;
	private String address;
	private Collection<PhoneEntry> numbers;

	public Contact(String name, String address) {
		this.name = name;
		this.address = address;
		this.numbers = new HashSet<PhoneEntry>();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void addPhoneEntry(PhoneEntry entry) {
		numbers.add(entry);
	}

	public Collection<PhoneEntry> getPhoneEntries() {
		return numbers;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", address=" + address + ", numbers= "
				+ numbers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
