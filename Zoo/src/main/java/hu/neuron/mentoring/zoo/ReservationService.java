package hu.neuron.mentoring.zoo;

import java.util.ArrayList;
import java.util.Calendar;

public class ReservationService {
	
	private static ReservationService singleInsance = null;
	
	
	private ReservationService() {
		
	}
	
	
	public static synchronized ReservationService getInstance()
    {
        if (singleInsance == null)
        	singleInsance = new ReservationService();
  
        return singleInsance;
    }
	
	
	public void  reserveTicket(Zoo zoo) {
		ArrayList<Ticket> tickets = new ArrayList<>();

		tickets.add(new Ticket(TicketType.ADULT, TicketVariant.FULL_DAY, 1500));

		synchronized(this) {
			zoo.reserve(new Reservation("PappDavid", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(),
					tickets, 25, 1200));
		}
		
	}

}
