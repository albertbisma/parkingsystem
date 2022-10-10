package com.apps.parkingsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
public class Tickets {

	public Tickets() {
		
	}
	


	public Tickets(String ticketNumber, Date dateTimeIn, Date dateTimeOut, String barcode,
			Integer idPaymentMethods, String checkoutBy, String platNumber, Boolean isPayment, Integer idVehicleTypes, Integer totalHour,
			Long totalCost) {
		super();
		this.ticketNumber = ticketNumber;
		this.dateTimeIn = dateTimeIn;
		this.dateTimeOut = dateTimeOut;
		this.barcode = barcode;
		this.idPaymentMethods = idPaymentMethods;
		this.checkoutBy = checkoutBy;
		this.platNumber = platNumber;
		this.isPayment = isPayment;
		this.idVehicleTypes = idVehicleTypes;
		this.totalHour = totalHour;
		this.totalCost = totalCost;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="ticket_number")
	private String ticketNumber;
	
	@Column(name = "datetime_in")
	private Date dateTimeIn;
	
	@Column(name = "datetime_out")
	private Date dateTimeOut;
	
	@Column(name = "barcode")
	private String barcode;
	
    @Column(name = "id_payment_methods")
	private Integer idPaymentMethods;
	
	@Column(name = "checkout_by")
	private String checkoutBy;
	
	@Column(name = "plat_number")
	private String platNumber;
	
	@Column(name = "is_payment")
	private Boolean isPayment;
	
	@Column(name = "id_vehicle_types")
	private Integer idVehicleTypes;
	
	@Column(name = "total_hour")
	private Integer totalHour;
	
	@Column(name = "total_cost")
	private Long totalCost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIdPaymentMethods() {
		return idPaymentMethods;
	}

	public void setIdPaymentMethods(Integer idPaymentMethods) {
		this.idPaymentMethods = idPaymentMethods;
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

	public Integer getIdVehicleTypes() {
		return idVehicleTypes;
	}

	public void setIdVehicleTypes(Integer idVehicleTypes) {
		this.idVehicleTypes = idVehicleTypes;
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
