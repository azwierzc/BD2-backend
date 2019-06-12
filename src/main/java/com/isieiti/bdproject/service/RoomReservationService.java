package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.RoomReservation;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.RoomReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class RoomReservationService {

    private final RoomReservationRepository repository;

    @Transactional(readOnly = true)
    public RoomReservation findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RoomReservation", "id", id));
    }

    @Transactional(readOnly = true)
    public List<RoomReservation> getAllRoomReservations() {
        return repository.findAllByOrderByStartTimestamp().stream()
                .filter(reservation -> reservation.getEndTimestamp().isAfter(now()))
                .collect(toList());
    }

    @Transactional
    public RoomReservation saveRoomReservation(RoomReservation roomReservation) {
        LocalDateTime startTime = roomReservation.getStartTimestamp();
        LocalDateTime endTime = roomReservation.getEndTimestamp();
        roomReservation.setStartTimestamp(startTime.plusHours(2));
        roomReservation.setEndTimestamp(endTime.plusHours(2));
        return repository.save(roomReservation);
    }

    @Transactional
    public void deleteRoomReservation(Long id) {
        repository.deleteById(id);
    }
}
