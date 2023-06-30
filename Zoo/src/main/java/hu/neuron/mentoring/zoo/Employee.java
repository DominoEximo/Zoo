package hu.neuron.mentoring.zoo;
import java.util.Objects;

public abstract class Employee {

	private String name;
	private int birthDate;
	private char gender;

	public Employee(String name, int birth_date, char gender) {
		super();
		this.name = name;
		this.birthDate = birth_date;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth_date() {
		return birthDate;
	}

	public void setBirth_date(int birth_date) {
		this.birthDate = birth_date;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
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
		return "Employee [name=" + name + ", birth_date=" + birthDate + ", gender=" + gender + "]";
	}

}
