package hu.neuron.mentoring.zoo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StoreZooTest {

	StoreZoo storage = new StoreZoo();
	
	Zoo zoo = new Zoo(new Director("Bella", null, null, 'f'));
	
	Zoo zoo2 = new Zoo();
	
	
	@Test
	public void storeZooTest() {
		
		storage.saveZoo(zoo);
		
		storage.loadZoo(zoo2);
		
		Assertions.assertEquals(zoo.getDirector(), zoo2.getDirector());
	}
	
	

}
