package hu.neuron.mentoring.zoo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;

import com.sun.tools.sjavac.Log.Level;

public class Main {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(Zoo.class.getName());

		Zoo zoo1 = new Zoo();

		Calendar adamBirthDate = Calendar.getInstance();
		adamBirthDate.set(Calendar.YEAR, 1950);
		adamBirthDate.set(Calendar.MONTH, Calendar.FEBRUARY);
		adamBirthDate.set(Calendar.DAY_OF_MONTH, 2);
		Calendar adamAppointmentDate = Calendar.getInstance();
		adamAppointmentDate.set(Calendar.YEAR, 2008);
		adamAppointmentDate.set(Calendar.MONTH, Calendar.JANUARY);
		adamAppointmentDate.set(Calendar.DAY_OF_MONTH, 1);

		zoo1.setDirector(new Director("Adam", adamBirthDate.getTime(), adamAppointmentDate.getTime(), 'm'));

		try {
			zoo1.addAnimal(new Animal(Species.TIGER, "Tigi", 20140502, 'f'));
		} catch (GondoZooNotAvailableException e) {
			logger.warning("Az állatkertnek nincs nincs megfelelő gondozója ehhez az állathoz!");
		}

		ArrayList<Species> carlAnimals = new ArrayList<>();

		carlAnimals.add(Species.TIGER);
		carlAnimals.add(Species.PENGUIN);

		Calendar carlBirthDate = Calendar.getInstance();
		carlBirthDate.set(Calendar.YEAR, 1970);
		carlBirthDate.set(Calendar.MONTH, Calendar.MARCH);
		carlBirthDate.set(Calendar.DAY_OF_MONTH, 7);
		Calendar carlAppointmentDate = Calendar.getInstance();

		zoo1.addEmployee(
				new GondoZoo("Carl", carlBirthDate.getTime(), carlAppointmentDate.getTime(), 'm', carlAnimals));

		try {
			zoo1.addAnimal(new Animal(Species.TIGER, "Tigi", 20140502, 'f'));
		} catch (GondoZooNotAvailableException e) {
			logger.warning("Az állatkertnek nincs nincs megfelelő gondozója ehhez az állathoz!");
		}

		Calendar evaBirthDate = Calendar.getInstance();
		evaBirthDate.set(Calendar.YEAR, 1990);
		evaBirthDate.set(Calendar.MONTH, Calendar.APRIL);
		evaBirthDate.set(Calendar.DAY_OF_MONTH, 4);
		Calendar evaAppointmentDate = Calendar.getInstance();
		evaAppointmentDate.set(Calendar.YEAR, 2010);
		evaAppointmentDate.set(Calendar.MONTH, Calendar.JANUARY);
		evaAppointmentDate.set(Calendar.DAY_OF_MONTH, 1);

		zoo1.setDirector(new Director("Eva", evaBirthDate.getTime(), evaAppointmentDate.getTime(), 'f'));

		try {
			zoo1.fireDirector();
		} catch (ZooEmployeeException e) {
			logger.warning("Az állatkertnek nincs igazgatója!");
		}

		zoo1.setDirector(new Director("Eva", evaBirthDate.getTime(), evaAppointmentDate.getTime(), 'f'));
		ArrayList<Species> earlAnimals = new ArrayList<>();

		earlAnimals.add(Species.PEACOCK);
		earlAnimals.add(Species.GIRAFFE);

		Calendar earlBirthDate = Calendar.getInstance();
		earlBirthDate.set(Calendar.YEAR, 1990);
		earlBirthDate.set(Calendar.MONTH, Calendar.APRIL);
		earlBirthDate.set(Calendar.DAY_OF_MONTH, 2);
		Calendar earlAppointmentDate = Calendar.getInstance();
		earlAppointmentDate.set(Calendar.YEAR, 2015);
		earlAppointmentDate.set(Calendar.MONTH, Calendar.JUNE);
		earlAppointmentDate.set(Calendar.DAY_OF_MONTH, 10);

		zoo1.addEmployee(
				new GondoZoo("Earl", earlBirthDate.getTime(), earlAppointmentDate.getTime(), 'm', earlAnimals));

		try {
			zoo1.addAnimal(new Animal(Species.GIRAFFE, "Giri", 20160911, 'm'));
		} catch (GondoZooNotAvailableException e) {
			logger.warning("Az állatkertnek nincs nincs megfelelő gondozója ehhez az állathoz!");
		}

		zoo1.listAnimals();

		zoo1.sortAnimals();

		Zoo zoo2 = new Zoo();

		Zoo.listZoos();

		Zoo.Moving move1 = zoo1.new Moving();

		move1.move(zoo1, zoo2);

		zoo1.listAnimals();

		zoo1.listEmployees();

		zoo2.listAnimals();

		zoo2.listEmployees();

		try {
			zoo2.fireDirector();
		} catch (ZooEmployeeException e) {
			logger.warning("Az állatkertnek nincs igazgatója!");
		}

		try {
			zoo2.fireGondoZoo((GondoZoo) zoo2.getEployees().get(0));
		} catch (ZooEmployeeException e) {
			logger.warning("Az állatkertnek szüksége van erre a dolgozóra!");
		}

		zoo2.sellAnimal(zoo2.getAnimals().get(0));

		zoo2.sellAnimal(zoo2.getAnimals().get(0));

		try {
			zoo2.fireGondoZoo((GondoZoo) zoo2.getEployees().get(1));
		} catch (ZooEmployeeException e) {

			logger.warning("Az állatkertnek szüksége van erre a dolgozóra!");
		}

		zoo2.listAnimals();

		zoo2.listEmployees();

		ArrayList<CleanedArea> bobAreas = new ArrayList<>();

		bobAreas.add(CleanedArea.TERRARIUM);
		bobAreas.add(CleanedArea.RUNWAY);

		zoo2.addEmployee(
				new Cleaner("Bob", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 'm', bobAreas));

		ArrayList<CleanedArea> annaAreas = new ArrayList<>();

		annaAreas.add(CleanedArea.CAGE);
		annaAreas.add(CleanedArea.POOL);

		zoo2.addEmployee(new Cleaner("Anna", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 'f',
				annaAreas));

		zoo2.checkRewardApplicability();

		zoo2.listRewardApplicables();

		zoo2.listEmployees();

		zoo2.autoLogAllJobs(zoo2.getEployees());

		zoo2.listLoggedJobs();

		Description<AnimalAttributes> desc1 = new Description<>(new AnimalAttributes("Russia", true, 12, true));

		Description<AnimalAttributes> desc2 = new Description<>(new AnimalAttributes("Africa", false, 10, false));

		Description<AnimalAttributes> desc3 = new Description<>(new AnimalAttributes("Kongo", false, 7, true));

		Description<AnimalAttributes> desc4 = new Description<>(new AnimalAttributes("Litvania", true, 16, false));

		zoo2.createSight(new Sight("Tigris ketrec", 1425, null, Species.TIGER, zoo2.getEployees().get(0), desc1));
		zoo2.createSight(new Sight("Pingvin kifutó", 9953, null, Species.PENGUIN, zoo2.getEployees().get(0), desc2));
		zoo2.createSight(new Sight("Peacock kifutó", 3364, null, Species.PEACOCK, zoo2.getEployees().get(0), desc3));
		zoo2.createSight(new Sight("Zsiráf kifutó", 2264, null, Species.GIRAFFE, zoo2.getEployees().get(0), desc4));
		zoo2.createSight(new Sight("Pingvin kifutó", 2664, null, Species.PENGUIN, zoo2.getEployees().get(0), desc2));
		zoo2.createSight(new Sight("Peacock kifutó", 2364, null, Species.PEACOCK, zoo2.getEployees().get(0), desc3));

		zoo2.listSights();

		try {
			zoo2.addAnimal(new Animal(Species.PENGUIN, "Pengu", Calendar.getInstance().getWeekYear(), 'f'));
			zoo2.addAnimal(new Animal(Species.PENGUIN, "Bengu", Calendar.getInstance().getWeekYear(), 'f'));
			zoo2.addAnimal(new Animal(Species.PENGUIN, "Lengu", Calendar.getInstance().getWeekYear(), 'f'));
			zoo2.addAnimal(new Animal(Species.PENGUIN, "Aengu", Calendar.getInstance().getWeekYear(), 'f'));
		} catch (GondoZooNotAvailableException e) {
			logger.warning("Az állatkertnek nincs nincs megfelelő gondozója ehhez az állathoz!");
		}
		zoo2.listAnimalsWithSpecies(Species.PENGUIN);
	}

}
