import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Zoo zoo1 = new Zoo();

		zoo1.setDirector(new Director("Adam", 19960205, 'm'));

		zoo1.addAnimal(new Animal(Species.TIGER, "Tigi", 20140502, 'f'));

		ArrayList<Species> carlAnimals = new ArrayList<>();

		carlAnimals.add(Species.TIGER);
		carlAnimals.add(Species.PENGUIN);

		zoo1.addEmployee(new GondoZoo("Carl", 20020405, 'm', carlAnimals));

		zoo1.addAnimal(new Animal(Species.TIGER, "Tigi", 20140502, 'f'));

		zoo1.setDirector(new Director("Eva", 19960207, 'f'));

		ArrayList<Species> earlAnimals = new ArrayList<>();

		earlAnimals.add(Species.PEACOCK);
		earlAnimals.add(Species.GIRAFFE);

		zoo1.addEmployee(new GondoZoo("Earl", 19770603, 'm', earlAnimals));

		zoo1.addAnimal(new Animal(Species.GIRAFFE, "Giri", 20160911, 'm'));

		zoo1.listAnimals();

		zoo1.sortAnimals();

		Zoo zoo2 = new Zoo();

		zoo2.listZoos();

		Zoo.Moving move1 = zoo1.new Moving();

		move1.move(zoo1, zoo2);

		zoo1.listAnimals();

		zoo1.listEmployees();

		zoo2.listAnimals();

		zoo2.listEmployees();

		zoo2.fireDirector();

		zoo2.fireGondoZoo((GondoZoo) zoo2.getEployees().get(0));

		zoo2.sellAnimal(zoo2.getAnimals().get(0));

		zoo2.sellAnimal(zoo2.getAnimals().get(0));

		zoo2.fireGondoZoo((GondoZoo) zoo2.getEployees().get(1));

		zoo2.listAnimals();

		zoo2.listEmployees();

	}

}
