package inputOutput;

import java.io.Serializable;

public class PhoneEntry implements Serializable {
	private static final long serialVersionUID = 180741589231808070L;
	private final String number;
	private final String description;

	public PhoneEntry(String number, String description) {
		this.number = number;
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		PhoneEntry other = (PhoneEntry) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return description + ": " + number;
	}
}
