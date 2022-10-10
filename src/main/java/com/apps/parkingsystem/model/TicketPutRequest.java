package com.apps.parkingsystem.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TicketPutRequest{
	public TicketPutRequest() {
		
	}	
	
	public TicketPutRequest(Date dateTimeOut, Integer idPaymentMethods, Integer idVehicleTypes,
			String checkOutBy, String platNumber, Boolean isPayment, Long totalCost, Integer totalHour) {
		this.dateTimeOut = dateTimeOut;
		this.idPaymentMethods = idPaymentMethods;
		this.idVehicleTypes = idVehicleTypes;
		this.checkOutBy = checkOutBy;
		this.platNumber = platNumber;
		this.isPayment = isPayment;
		this.totalCost = totalCost;
		this.totalHour = totalHour;
	}

	private Date dateTimeOut;
	private Integer idPaymentMethods;
	private Integer idVehicleTypes;
	private String checkOutBy;
	private String platNumber;
	private Boolean isPayment;
	private Long totalCost;
	private Integer totalHour;
	
	public Date getDateTimeOut() {
		return dateTimeOut;
	}

	public void setDateTimeOut(Date dateTimeOut) {
		this.dateTimeOut = dateTimeOut;
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

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(Integer totalHour) {
		this.totalHour = totalHour;
	}
	
	
}
