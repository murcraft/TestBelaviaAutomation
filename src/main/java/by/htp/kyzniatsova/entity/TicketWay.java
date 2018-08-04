package by.htp.kyzniatsova.entity;

import java.io.Serializable;

public class TicketWay implements Serializable, Comparable<TicketWay> {

	private static final long serialVersionUID = 9219949723385721862L;
	
	private String departureDate;
	private String returnDate;
	private String ticketPrice;
	
	public TicketWay() {
	}
	
	public TicketWay(String departureDate, String returnDate, String ticketPrice) {
		super();
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.ticketPrice = ticketPrice;
	}
	
	public String getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	public String getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	public String getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((ticketPrice == null) ? 0 : ticketPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketWay other = (TicketWay) obj;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (ticketPrice == null) {
			if (other.ticketPrice != null)
				return false;
		} else if (!ticketPrice.equals(other.ticketPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketWay [departureDate=" + departureDate + ", departureTime=" + returnDate + ", ticketPrice="
				+ ticketPrice + "]";
	}
	
	public int compareTo(TicketWay ticket) {
		String pattern = "[^0-9]";
		String thisPrise = this.ticketPrice.replaceAll(pattern, "");
		int price = Integer.parseInt(thisPrise);

		String result = ticket.getTicketPrice().replaceAll(pattern, "");
		int otherPrice = Integer.parseInt(result);
		if (price > otherPrice) {
			return 1;
		} else if (price < otherPrice) {
			return -1;
		} else {
			return 0;
		}
	}

}
