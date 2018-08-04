package by.htp.kyzniatsova.entity;

import java.io.Serializable;

public class TicketTwoWays implements Serializable {

	private static final long serialVersionUID = -6253403149367259226L;
	
	private String departureDateFrom;
	private String departureTimeFrom;
	private String flightClassFrom;
	private String ticketPriceFrom;
	
	private String departureDateTo;
	private String departureTimeTo;
	private String flightClassTo;
	private String ticketPriceTo;
	
	public TicketTwoWays() {
		
	}

	public TicketTwoWays(String departureDateFrom, String departureTimeFrom, String flightClassFrom,
			String ticketPriceFrom, String departureDateTo, String departureTimeTo, String flightClassTo,
			String ticketPriceTo) {
		super();
		this.departureDateFrom = departureDateFrom;
		this.departureTimeFrom = departureTimeFrom;
		this.flightClassFrom = flightClassFrom;
		this.ticketPriceFrom = ticketPriceFrom;
		this.departureDateTo = departureDateTo;
		this.departureTimeTo = departureTimeTo;
		this.flightClassTo = flightClassTo;
		this.ticketPriceTo = ticketPriceTo;
	}

	public String getDepartureDateFrom() {
		return departureDateFrom;
	}

	public void setDepartureDateFrom(String departureDateFrom) {
		this.departureDateFrom = departureDateFrom;
	}

	public String getDepartureTimeFrom() {
		return departureTimeFrom;
	}

	public void setDepartureTimeFrom(String departureTimeFrom) {
		this.departureTimeFrom = departureTimeFrom;
	}

	public String getFlightClassFrom() {
		return flightClassFrom;
	}

	public void setFlightClassFrom(String flightClassFrom) {
		this.flightClassFrom = flightClassFrom;
	}

	public String getTicketPriceFrom() {
		return ticketPriceFrom;
	}

	public void setTicketPriceFrom(String ticketPriceFrom) {
		this.ticketPriceFrom = ticketPriceFrom;
	}

	public String getDepartureDateTo() {
		return departureDateTo;
	}

	public void setDepartureDateTo(String departureDateTo) {
		this.departureDateTo = departureDateTo;
	}

	public String getDepartureTimeTo() {
		return departureTimeTo;
	}

	public void setDepartureTimeTo(String departureTimeTo) {
		this.departureTimeTo = departureTimeTo;
	}

	public String getFlightClassTo() {
		return flightClassTo;
	}

	public void setFlightClassTo(String flightClassTo) {
		this.flightClassTo = flightClassTo;
	}

	public String getTicketPriceTo() {
		return ticketPriceTo;
	}

	public void setTicketPriceTo(String ticketPriceTo) {
		this.ticketPriceTo = ticketPriceTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureDateFrom == null) ? 0 : departureDateFrom.hashCode());
		result = prime * result + ((departureDateTo == null) ? 0 : departureDateTo.hashCode());
		result = prime * result + ((departureTimeFrom == null) ? 0 : departureTimeFrom.hashCode());
		result = prime * result + ((departureTimeTo == null) ? 0 : departureTimeTo.hashCode());
		result = prime * result + ((flightClassFrom == null) ? 0 : flightClassFrom.hashCode());
		result = prime * result + ((flightClassTo == null) ? 0 : flightClassTo.hashCode());
		result = prime * result + ((ticketPriceFrom == null) ? 0 : ticketPriceFrom.hashCode());
		result = prime * result + ((ticketPriceTo == null) ? 0 : ticketPriceTo.hashCode());
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
		TicketTwoWays other = (TicketTwoWays) obj;
		if (departureDateFrom == null) {
			if (other.departureDateFrom != null)
				return false;
		} else if (!departureDateFrom.equals(other.departureDateFrom))
			return false;
		if (departureDateTo == null) {
			if (other.departureDateTo != null)
				return false;
		} else if (!departureDateTo.equals(other.departureDateTo))
			return false;
		if (departureTimeFrom == null) {
			if (other.departureTimeFrom != null)
				return false;
		} else if (!departureTimeFrom.equals(other.departureTimeFrom))
			return false;
		if (departureTimeTo == null) {
			if (other.departureTimeTo != null)
				return false;
		} else if (!departureTimeTo.equals(other.departureTimeTo))
			return false;
		if (flightClassFrom == null) {
			if (other.flightClassFrom != null)
				return false;
		} else if (!flightClassFrom.equals(other.flightClassFrom))
			return false;
		if (flightClassTo == null) {
			if (other.flightClassTo != null)
				return false;
		} else if (!flightClassTo.equals(other.flightClassTo))
			return false;
		if (ticketPriceFrom == null) {
			if (other.ticketPriceFrom != null)
				return false;
		} else if (!ticketPriceFrom.equals(other.ticketPriceFrom))
			return false;
		if (ticketPriceTo == null) {
			if (other.ticketPriceTo != null)
				return false;
		} else if (!ticketPriceTo.equals(other.ticketPriceTo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketTwoWays [departureDateFrom=" + departureDateFrom + ", departureTimeFrom=" + departureTimeFrom
				+ ", flightClassFrom=" + flightClassFrom + ", ticketPriceFrom=" + ticketPriceFrom + ", departureDateTo="
				+ departureDateTo + ", departureTimeTo=" + departureTimeTo + ", flightClassTo=" + flightClassTo
				+ ", ticketPriceTo=" + ticketPriceTo + "]";
	}


}
