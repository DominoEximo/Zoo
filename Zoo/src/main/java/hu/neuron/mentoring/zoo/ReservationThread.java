package hu.neuron.mentoring.zoo;

import java.util.ArrayList;
import java.util.Calendar;

public class ReservationThread implements Runnable {

	Zoo zoo;

	public ReservationThread(Zoo zoo) {
		super();
		this.zoo = zoo;
	}

	@Override
	public void run() {
		ReservationService.getInstance().reserveTicket(zoo);


	}

	public void reserveTicket(Zoo zoo) {
		ArrayList<Ticket> tickets = new ArrayList<>();

		tickets.add(new Ticket(TicketType.ADULT, TicketVariant.FULL_DAY, 1500));

		zoo.reserve(new Reservation("PappDavid", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(),
				tickets, 25, 1200));
	}

}
