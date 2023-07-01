package hu.neuron.mentoring.zoo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Cleaner extends Employee {

	private ArrayList<CleanedArea> cleanedAreas;

	public Cleaner(String name, Date birthDate, Date appointmentDate, Character gender, ArrayList<CleanedArea> cleanedAreas) {
		super(name, birthDate,appointmentDate, gender);
		this.cleanedAreas = cleanedAreas;
	}

	public ArrayList<CleanedArea> getCleanedAreas() {
		return cleanedAreas;
	}

	public void setCleanedAreas(ArrayList<CleanedArea> cleanedAreas) {
		this.cleanedAreas = cleanedAreas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cleanedAreas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cleaner other = (Cleaner) obj;
		return Objects.equals(cleanedAreas, other.cleanedAreas);
	}

	@Override
	public String toString() {
		return super.toString() + "cleanedAreas=" + cleanedAreas;
	}
	
	
}
