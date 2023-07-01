package hu.neuron.mentoring.zoo;

import java.util.Date;

public class Director extends Employee {

	public Director(String name, Date birthDate, Date appointmentDate, Character gender) {
		super(name, birthDate, appointmentDate, gender);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
