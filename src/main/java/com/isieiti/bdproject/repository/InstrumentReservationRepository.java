package com.isieiti.bdproject.repository;

import com.isieiti.bdproject.entity.Instrument;
import com.isieiti.bdproject.entity.InstrumentReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentReservationRepository extends JpaRepository<InstrumentReservation, Long> {

    List<InstrumentReservation> findAllByOrderByStartTimestamp();

    List<InstrumentReservation> findAllByInstrumentId(Long id);
}
