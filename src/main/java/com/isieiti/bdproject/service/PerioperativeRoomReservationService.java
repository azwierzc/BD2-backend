package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.PerioperativeRoomReservation;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.PerioperativeRoomReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerioperativeRoomReservationService {

    private final PerioperativeRoomReservationRepository repository;

    @Transactional(readOnly = true)
    public PerioperativeRoomReservation findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PerioperativeRoomReservation", "id", id));
    }

    @Transactional(readOnly = true)
    public List<PerioperativeRoomReservation> getAllPerioperativeRoomReservations() {
        return repository.findAll();
    }

    @Transactional
    public PerioperativeRoomReservation postPerioperativeRoomReservation(PerioperativeRoomReservation perioperativeRoomReservation) {
        return repository.save(perioperativeRoomReservation);
    }

    @Transactional
    public void deletePerioperativeRoomReservation(Long id) {
        repository.deleteById(id);
    }
}
