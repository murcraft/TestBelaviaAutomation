package by.htp.kyzniatsova.entity;

import java.util.Comparator;

public class TicketCostComparator implements Comparator<Ticket> {

	public int compare(Ticket ticket1, Ticket ticket2) {
		if(ticket1.getTicketPrice() > ticket2.getTicketPrice()) {
			return 1;
		} else if (ticket1.getTicketPrice() < ticket2.getTicketPrice()) {
			return -1;
		} else {
			return 0;
		}
	}

}
