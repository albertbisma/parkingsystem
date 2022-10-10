package com.apps.parkingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apps.parkingsystem.entity.Tickets;

@Transactional
@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Integer> {
	@Query(nativeQuery = true, value = "SELECT MAX(ID) as ID FROM PARKING_MANAGEMENT.TICKETS")
	Integer getLastIdFromTickets();

}
