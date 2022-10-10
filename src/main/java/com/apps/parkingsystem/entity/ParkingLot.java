package com.apps.parkingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parking_lot")
@Setter
@Getter
public class ParkingLot {

	public ParkingLot() {
		
	}	
	
	public ParkingLot(Integer idVehicleTypes, Long availableLot, Long filledLot) {
		super();
		this.idVehicleTypes = idVehicleTypes;
		this.availableLot = availableLot;
		this.filledLot = filledLot;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
    @Column(name="id_vehicle_types")
	private Integer idVehicleTypes;
	
	@Column(name = "available_lot")
	private Long availableLot;

	@Column(name = "filled_lot")
	private Long filledLot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdVehicleTypes() {
		return idVehicleTypes;
	}

	public void setIdVehicleTypes(Integer idVehicleTypes) {
		this.idVehicleTypes = idVehicleTypes;
	}

	public Long getAvailableLot() {
		return availableLot;
	}

	public void setAvailableLot(Long availableLot) {
		this.availableLot = availableLot;
	}

	public Long getFilledLot() {
		return filledLot;
	}

	public void setFilledLot(Long filledLot) {
		this.filledLot = filledLot;
	}	
	
	
}
