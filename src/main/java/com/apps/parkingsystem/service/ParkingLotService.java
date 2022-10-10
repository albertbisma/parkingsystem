package com.apps.parkingsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.parkingsystem.entity.ParkingLot;
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
	
	public void update(ParkingLotRequest request, Integer id) {
		 parkingLotRepository.findById(id).map(parkingLot -> {
			parkingLot.setAvailableLot(request.getAvailableLot());
			parkingLot.setFilledLot(request.getFilledLot());
			return parkingLotRepository.save(parkingLot);
		}).get();
	}
	
	public void delete(Integer id) {
		parkingLotRepository.deleteById(id);
	}
	
}
