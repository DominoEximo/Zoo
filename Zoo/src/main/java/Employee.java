import java.util.Objects;

public abstract class Employee {

	private String name;
	private int birth_date;
	private char gender;

	public Employee(String name, int birth_date, char gender) {
		super();
		this.name = name;
		this.birth_date = birth_date;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(int birth_date) {
		this.birth_date = birth_date;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birth_date, gender, name);
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
		return birth_date == other.birth_date && gender == other.gender && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", birth_date=" + birth_date + ", gender=" + gender + "]";
	}

}
