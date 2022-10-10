package com.apps.parkingsystem.model;

import com.apps.parkingsystem.entity.Tickets;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"GenericResponse", "tickets"})
@JsonInclude(Include.NON_NULL)
public class TicketsResponse extends BaseResponse{
	private Tickets tickets;

	public Tickets getTickets() {
		return tickets;
	}

	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}
	
}
