package by.htp.kyzniatsova.entity;

import java.util.Comparator;

public class TicketDateComporator implements Comparator<Ticket> {

	public int compare(Ticket ticket1, Ticket ticket2) {
		return ticket1.getDepartureDate().compareTo(ticket2.getDepartureDate());
	}
	
	
}
