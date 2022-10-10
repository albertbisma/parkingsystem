package com.apps.parkingsystem.model;

import java.util.Date;

import com.apps.parkingsystem.entity.Tickets;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"GenericResponse", "tickets"})
@JsonInclude(Include.NON_NULL)
public class TicketsResponse extends BaseResponse{
	private Tickets tickets;
	private String ticketNumber;
	private Date dateTimeIn;
	private Date dateTimeOut;
	private String barcode;
	private String checkoutBy;
	private String platNumber;
	private Boolean isPayment;
	private Integer totalHour;
	private Long totalCost;

	public Tickets getTickets() {
		return tickets;
	}

	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Date getDateTimeIn() {
		return dateTimeIn;
	}

	public void setDateTimeIn(Date dateTimeIn) {
		this.dateTimeIn = dateTimeIn;
	}

	public Date getDateTimeOut() {
		return dateTimeOut;
	}

	public void setDateTimeOut(Date dateTimeOut) {
		this.dateTimeOut = dateTimeOut;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCheckoutBy() {
		return checkoutBy;
	}

	public void setCheckoutBy(String checkoutBy) {
		this.checkoutBy = checkoutBy;
	}

	public String getPlatNumber() {
		return platNumber;
	}

	public void setPlatNumber(String platNumber) {
		this.platNumber = platNumber;
	}

	public Boolean getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(Boolean isPayment) {
		this.isPayment = isPayment;
	}

	public Integer getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(Integer totalHour) {
		this.totalHour = totalHour;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
