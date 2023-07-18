package hu.neuron.mentoring.zoo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReservationThreadPool {
	
	ExecutorService executor = Executors.newFixedThreadPool(5);
}
