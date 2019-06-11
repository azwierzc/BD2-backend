package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.InstrumentReservation;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.InstrumentReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class InstrumentReservationService {

    private final InstrumentReservationRepository repository;

    public InstrumentReservation findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instrument Reservation", "id", id));
    }

    public List<InstrumentReservation> getAllInstrumentReservations() {
        return repository.findAllOrderByStartTimestamp().stream()
                .filter(reservation -> reservation.getEndTimestamp().isAfter(now()))
                .collect(toList());
    }

    @Transactional
    public InstrumentReservation postInstrumentReservation(InstrumentReservation instrumentReservation) {
        return repository.save(instrumentReservation);
    }

    public void deleteInstrumentReservation(Long id) {
        repository.deleteById(id);
    }
}
