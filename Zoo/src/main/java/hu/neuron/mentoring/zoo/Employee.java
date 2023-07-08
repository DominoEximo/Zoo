package hu.neuron.mentoring.zoo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class Employee implements Serializable{

	private String name;
	private Date birthDate;
	private Date appointmentDate;
	private Character gender;

	public Employee(String name, Date birthDate,Date appointmentDate, char gender) {
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

	public char getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(appointmentDate, birthDate, gender, name);
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
		return Objects.equals(appointmentDate, other.appointmentDate) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", birthDate=" + birthDate +", appointmentDate=" + appointmentDate + ", gender=" + gender + "]";
	}

}
