package by.htp.kyzniatsova.entity;

import java.io.Serializable;

public class TicketOneWay implements Serializable {

	private static final long serialVersionUID = 9219949723385721862L;
	
	private String departureDate;
	private String departureTime;
	private String flightClass;
	private String ticketPrice;
	
	public TicketOneWay() {
	}
	
	public TicketOneWay(String departureDate, String departureTime, String flightClass, String ticketPrice) {
		super();
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.flightClass = flightClass;
		this.ticketPrice = ticketPrice;
	}
	
	public String getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public String getFlightClass() {
		return flightClass;
	}
	
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
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
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightClass == null) ? 0 : flightClass.hashCode());
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
		TicketOneWay other = (TicketOneWay) obj;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (flightClass == null) {
			if (other.flightClass != null)
				return false;
		} else if (!flightClass.equals(other.flightClass))
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
		return "Ticket [departureDate=" + departureDate + ", departureTime=" + departureTime + ", flightClass="
				+ flightClass + ", ticketPrice=" + ticketPrice + "]";
	}
		

}
