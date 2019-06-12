package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.InstrumentReservation;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.InstrumentReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class InstrumentReservationService {

    private final InstrumentReservationRepository repository;

    @Transactional(readOnly = true)
    public InstrumentReservation findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instrument Reservation", "id", id));
    }

    @Transactional(readOnly = true)
    public List<InstrumentReservation> getAllInstrumentReservations() {
        return repository.findAllByOrderByStartTimestamp().stream()
                .filter(reservation -> reservation.getEndTimestamp().isAfter(LocalDateTime.now()))
                .collect(toList());
    }

    @Transactional
    public InstrumentReservation postInstrumentReservation(InstrumentReservation instrumentReservation) {
        instrumentReservation.getEndTimestamp().plusHours(2);
        instrumentReservation.getStartTimestamp().plusHours(2);
        return repository.save(instrumentReservation);
    }

    @Transactional
    public void deleteInstrumentReservation(Long id) {
        repository.deleteById(id);
    }
}
