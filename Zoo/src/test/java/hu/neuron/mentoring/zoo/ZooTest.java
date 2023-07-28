package hu.neuron.mentoring.zoo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ZooTest {

	Zoo zoo = new Zoo();

	@Test
	public void reserveTest() {

		zoo.reserve(new Reservation(null, null, null, null, null, null));

		Assertions.assertEquals(1, zoo.getReservations().size());
	}

	@Test
	public void flushReservationsTest() {
		zoo.flushReservations();

		Assertions.assertEquals(0, zoo.getReservations().size());
	}

	@Test
	public void addEmployeeTest() {
		zoo.addEmployee(null);

		Assertions.assertEquals(1, zoo.getEployees().size());

	}

}
