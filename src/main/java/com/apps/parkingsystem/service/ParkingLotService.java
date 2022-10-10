package com.apps.parkingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.parkingsystem.entity.ParkingLot;
import com.apps.parkingsystem.model.ParkingLotPutFilledLotRequest;
import com.apps.parkingsystem.model.ParkingLotRequest;
import com.apps.parkingsystem.repository.ParkingLotRepository;

@Service
public class ParkingLotService {
	
	@Autowired
	private ParkingLotRepository parkingLotRepository;
	
	public ParkingLot findById(Integer id) {
		return parkingLotRepository.findById(id).get();
	}		
	
	public ParkingLot insert(ParkingLotRequest request) {
		return parkingLotRepository.save(new ParkingLot(request.getIdVehicleTypes(), request.getAvailableLot(), request.getFilledLot()));
	}
	
	public void update(ParkingLotPutFilledLotRequest request, Integer id) {
		 parkingLotRepository.findById(id).map(parkingLot -> {
			parkingLot.setFilledLot(request.getFilledLot());
			return parkingLotRepository.save(parkingLot);
		}).get();
	}
	
	public ParkingLot findByIdVehicleTypes(Integer idVehicleTypes) {
		return parkingLotRepository.findByIdVehicleTypes(idVehicleTypes);
	}
	
	public List<ParkingLot> findAll() {
		return parkingLotRepository.findAll();
	}
	
	public void delete(Integer id) {
		parkingLotRepository.deleteById(id);
	}
	
}
