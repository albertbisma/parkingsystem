package com.apps.parkingsystem.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TicketCheckOutRequest{
	public TicketCheckOutRequest() {
		
	}	
	
	public TicketCheckOutRequest(Integer id, String barcode, Date dateTimeOut, Integer idPaymentMethods, Integer idVehicleTypes,
			String checkOutBy, String platNumber, Boolean isPayment, Long totalCost, Integer totalHour) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.idPaymentMethods = idPaymentMethods;
		this.idVehicleTypes = idVehicleTypes;
		this.checkOutBy = checkOutBy;
		this.platNumber = platNumber;
		this.isPayment = isPayment;
	}


	private Integer id;
	private String barcode;
	private Date dateTimeOut;
	private Integer idPaymentMethods;
	private Integer idVehicleTypes;
	private String checkOutBy;
	private String platNumber;
	private Boolean isPayment;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

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
}
