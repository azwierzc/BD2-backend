package com.isieiti.bdproject.repository;

import com.isieiti.bdproject.entity.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
}
