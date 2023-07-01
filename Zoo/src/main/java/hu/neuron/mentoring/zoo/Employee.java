package hu.neuron.mentoring.zoo;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class Employee {

	private String name;
	private Calendar birthDate;
	private Calendar appointmentDate;
	private Character gender;

	public Employee(String name, Calendar birthDate,Calendar appointmentDate, char gender) {
		this.name = name;
		this.birthDate = birthDate;
		this.appointmentDate = appointmentDate;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirth_date() {
		return birthDate;
	}

	public void setBirth_date(Calendar birth_date) {
		this.birthDate = birth_date;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return birthDate == other.birthDate && gender == other.gender && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", birth_date=" + birthDate +", appointment_date=" + appointmentDate + ", gender=" + gender + "]";
	}

}
