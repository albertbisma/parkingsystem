package com.apps.parkingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_methods")
@Setter
@Getter
public class PaymentMethods {

	public PaymentMethods() {
		
	}
	
	public PaymentMethods(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Column(name = "description")
	private String description;	
	
}
