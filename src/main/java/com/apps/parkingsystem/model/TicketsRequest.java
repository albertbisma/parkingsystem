package com.apps.parkingsystem.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TicketsRequest{
	public TicketsRequest() {
		
	}
	
	public TicketsRequest(String ticketNumber, Date dateTimeIn, Date dateTimeOut, String barcode,
			Integer idPaymentMethods, Integer idVehicleTypes, String checkOutBy, String platNumber, Boolean isPayment) {
		this.ticketNumber = ticketNumber;
		this.dateTimeIn = dateTimeIn;
		this.dateTimeOut = dateTimeOut;
		this.barcode = barcode;
		this.idPaymentMethods = idPaymentMethods;
		this.idVehicleTypes = idVehicleTypes;
		this.checkOutBy = checkOutBy;
		this.platNumber = platNumber;
		this.isPayment = isPayment;
	}
	
		
	private String ticketNumber;
	private Date dateTimeIn;
	private Date dateTimeOut;
	private String barcode;
	private Integer idPaymentMethods;
	private Integer idVehicleTypes;
	private String checkOutBy;
	private String platNumber;
	private Boolean isPayment;
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
	public Integer getIdPaymentMethods() {
		return idPaymentMethods;
	}

	public void setIdPaymentMethods(Integer idPaymentMethods) {
		this.idPaymentMethods = idPaymentMethods;
	}

	public Integer getIdVehicleTypes() {
		return idVehicleTypes;
	}

	public void setIdVehicleTypes(Integer idVehicleTypes) {
		this.idVehicleTypes = idVehicleTypes;
	}

	public String getCheckOutBy() {
		return checkOutBy;
	}
	public void setCheckOutBy(String checkOutBy) {
		this.checkOutBy = checkOutBy;
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
	
	
}
