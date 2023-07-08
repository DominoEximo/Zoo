package hu.neuron.mentoring.zoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

public class StoreZoo {

	Logger logger = Logger.getLogger(StoreZoo.class.getName());

	public void saveZoo(Zoo zoo) {
		try (FileOutputStream f = new FileOutputStream("src/main/resources/SavedZoo.txt");
				ObjectOutputStream o = new ObjectOutputStream(f)) {

			o.writeObject(zoo);

		} catch (IOException io) {
			logger.warning("IO Exception!");
		}
	}

	public void loadZoo(Zoo newZoo) {
		try (FileInputStream fi = new FileInputStream("src/main/resources/SavedZoo.txt");
				ObjectInputStream oi = new ObjectInputStream(fi)) {

			Zoo tempZoo = (Zoo) oi.readObject();
			
			newZoo = tempZoo;
			
		} catch (IOException io) {
			logger.warning("IO Exception!");
		} catch (ClassNotFoundException c) {
			logger.warning("Nincs lementett állatkert!");
		}
	}

}
