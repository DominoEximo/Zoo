package hu.neuron.mentoring.zoo;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.CompareToBuilder;

class Zoo {

	private static Logger logger = Logger.getLogger(Zoo.class.getName());

	private static int counter;

	private Director director;

	private ArrayList<Employee> employees;

	private ArrayList<Animal> animals;

	public Zoo() {
		employees = new ArrayList<>();
		animals = new ArrayList<>();
		counter++;
	}

	static {
		listZoos();
	}

	{
		logger.info(String.format("Az állatkert megalapulása: %s \n", LocalTime.now()));
	}

	public static void listZoos() {
		logger.info(String.format("Az országnak %d állatkertje van jelenleg. \n", counter));
	}

	public void listEmployees() {
		try {
			for (Employee employee : employees) {
				logger.info(
						String.format("%s %s %s", employee.getName(), employee.getBirth_date(), employee.getGender()));
			}
		} catch (NullPointerException e) {
			logger.info("Az állatkertnek nincsenek dolgozói!");
		}
	}

	public void addAnimal(Animal animal) {
		Boolean canBuy = false;
		if (employees != null) {
			for (Employee employee : employees) {
				if (employee instanceof GondoZoo) {
					if (((GondoZoo) employee).getSuppliedAnimals().contains(animal.getSpecies())) {
						canBuy = true;
						break;
					}
				}
			}
		}
		
		if (Boolean.TRUE.equals(canBuy)) {
			this.animals.add(animal);
			logger.info(String.format("Az állatkert befogadta a(z) %s nevű állatot! \n", animal.getNickname()));
		} else {
			logger.info(String.format("A %s állatot az állatkert nem tudja fogadni. \n", animal.getSpecies()));
		}
	}

	public void sellAnimal(Animal animal) {
		logger.info(String.format("Az %s nevú állatot eladták.", animal.getNickname()));
		this.animals.remove(animal);
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public void fireGondoZoo(GondoZoo employee) {

		Boolean canFire = true;

		Set<Species> caredAnimals = new HashSet<>();
		Set<Species> animalsInZoo = new HashSet<>();

		Species problematicAnimal = null;

		for (Employee caretaker : employees) {
			if (caretaker instanceof GondoZoo && !caretaker.equals(employee)) {
				caredAnimals.addAll(((GondoZoo) caretaker).getSuppliedAnimals());
			}
		}

		for (Animal animal : animals) {
			animalsInZoo.add(animal.getSpecies());
		}

		for (Species species : employee.getSuppliedAnimals()) {
			if (!caredAnimals.contains(species) && animalsInZoo.contains(species)) {
				canFire = false;

				problematicAnimal = species;
				break;
			}
		}

		if (Boolean.TRUE.equals(canFire)) {
			this.employees.remove(employee);
			logger.info(String.format("%s nevű dolgozó eltávozott! \n", employee.getName()));
		} else {
			logger.info(String.format("Az állatkertnek szüksége van %s gondozóra! \n", problematicAnimal));
		}

	}

	public void fireDirector() {
		if (this.director == null) {
			logger.info(String.format("Az állatkertnek nincs jelenleg igazgatója! \n"));
		} else {
			logger.info(String.format("Az állatkert %s igazgatója eltávozott! \n", director.getName()));
			this.director = null;
		}

	}

	public void animalCount() {
		logger.info(String.format("Az állatkertnek %d lakója van jelenleg! \n", animals.size()));
	}

	public void listAnimals() {
		if (animals != null) {
			for (Animal animal : animals) {
				logger.info(String.format("%s", animal));
			}
		}
			
		
	}

	public void sortAnimals() {
		Collections.sort(animals, new CompareAnimals());
		for (Animal animal : animals) {
			logger.info(String.format("%s", animal));
		}
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		if (this.director == null) {
			this.director = director;
			logger.info(String.format("Az állatkert igazgatója %s lett! \n", director.getName()));
		} else {
			logger.info(String.format("Az állatkertnek már van igazgatója. \n"));
		}

	}

	public ArrayList<Employee> getEployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> eployees) {
		this.employees = eployees;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	class Moving {

		public void move(Zoo from, Zoo to) {
			to.setAnimals(from.getAnimals());
			to.setDirector(from.getDirector());
			to.setEmployees(from.getEployees());
			counter--;
			from.setDirector(null);
			from.setAnimals(null);
			from.setEmployees(null);
		}

	}

	public class CompareAnimals implements Comparator<Animal> {

		@Override
		public int compare(Animal o1, Animal o2) {
			return new CompareToBuilder().append(o1.getSpecies(), o2.getSpecies())
					.append(o1.getNickname(), o2.getNickname()).build();
		}

	}
}
