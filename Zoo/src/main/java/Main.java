import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Zoo állatkert1 = new Zoo();

		állatkert1.setDirector(new Director("Adam", 19960205, 'm'));

		állatkert1.addAnimal(new Animal(Species.TIGER, "Tigi", 20140502, 'f'));

		ArrayList<Species> carlAnimals = new ArrayList<>();

		carlAnimals.add(Species.TIGER);
		carlAnimals.add(Species.PENGUIN);

		állatkert1.addEmployee(new GondoZoo("Carl", 20020405, 'm', carlAnimals));

		állatkert1.addAnimal(new Animal(Species.TIGER, "Tigi", 20140502, 'f'));

		állatkert1.setDirector(new Director("Eva", 19960207, 'f'));

		ArrayList<Species> earlAnimals = new ArrayList<>();

		earlAnimals.add(Species.PEACOCK);
		earlAnimals.add(Species.GIRAFFE);

		állatkert1.addEmployee(new GondoZoo("Earl", 19770603, 'm', earlAnimals));

		állatkert1.addAnimal(new Animal(Species.GIRAFFE, "Giri", 20160911, 'm'));

		állatkert1.listAnimals();

		állatkert1.sortAnimals();

		Zoo állatkert2 = new Zoo();

		állatkert2.listZoos();

		Zoo.Moving move1 = állatkert1.new Moving();

		move1.move(állatkert1, állatkert2);

		állatkert1.listAnimals();

		állatkert1.listEmployees();

		állatkert2.listAnimals();

		állatkert2.listEmployees();

		állatkert2.fireDirector();

		állatkert2.fireGondoZoo((GondoZoo) állatkert2.getEployees().get(0));

		állatkert2.sellAnimal(állatkert2.getAnimals().get(0));

		állatkert2.sellAnimal(állatkert2.getAnimals().get(0));

		állatkert2.fireGondoZoo((GondoZoo) állatkert2.getEployees().get(1));

		állatkert2.listAnimals();

		állatkert2.listEmployees();

	}

}
