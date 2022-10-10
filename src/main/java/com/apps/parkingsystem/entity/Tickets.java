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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tickets {

	public Tickets() {
		
	}
	


	public Tickets(String ticketNumber, Date dateTimeIn, Date dateTimeOut, String barcode,
			PaymentMethods idPaymentMethods, String checkoutBy, String platNumber, Boolean isPayment, Integer totalHour,
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
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "id_payment_methods")
	private PaymentMethods idPaymentMethods;
	
	@Column(name = "checkout_by")
	private String checkoutBy;
	
	@Column(name = "plat_number")
	private String platNumber;
	
	@Column(name = "is_payment")
	private Boolean isPayment;
	
	@Column(name = "total_hour")
	private Integer totalHour;
	
	@Column(name = "total_cost")
	private Long totalCost;
	
	

}
