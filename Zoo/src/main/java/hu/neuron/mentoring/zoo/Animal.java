package hu.neuron.mentoring.zoo;
import java.util.Objects;

public class Animal {

	private Species species;
	private String nickname;
	private int birth_date;
	private char gender;

	public Animal(Species species, String nickname, int birth_date, char gender) {
		super();
		this.species = species;
		this.nickname = nickname;
		this.birth_date = birth_date;
		this.gender = gender;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return Objects.hash(birth_date, gender, nickname, species);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return birth_date == other.birth_date && gender == other.gender && Objects.equals(nickname, other.nickname)
				&& species == other.species;
	}

	@Override
	public String toString() {
		return "Animal [species=" + species + ", nickname=" + nickname + ", birth_date=" + birth_date + ", gender="
				+ gender + "]";
	}

}
