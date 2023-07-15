package hu.neuron.mentoring.zoo;


import java.nio.file.Paths;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class StoreZoo {

	Logger logger = Logger.getLogger(StoreZoo.class.getName());

	public void saveZoo(Zoo zoo) {

		ObjectMapper Obj = new ObjectMapper();

		try {

			Obj.writeValue(new File("src/main/resources/SavedZoo.json"), zoo);

		} catch (IOException e) {
			logger.warning("IO Exception!");

		}
	}

	public void loadZoo(Zoo newZoo) {

		ObjectMapper mapper = new ObjectMapper();

		Zoo tempZoo;

		try {
			tempZoo = (Zoo) mapper.readValue(Paths.get("src/main/resources/SavedZoo.json").toFile(), Zoo.class);
			
			newZoo.setEmployees(tempZoo.getEployees());
			newZoo.setDirector(tempZoo.getDirector());
			newZoo.setAnimals(tempZoo.getAnimals());
			newZoo.setReservations(tempZoo.getReservations());
		} catch (IOException e) {

			logger.warning("IO Exception!");
		}

	}

}
