package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.RoomReservation;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.RoomReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class RoomReservationService {

    private final RoomReservationRepository repository;

    public RoomReservation findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RoomReservation", "id", id));
    }

    public List<RoomReservation> getAllRoomReservations() {
        return repository.findAllOrderByStartTimestamp().stream()
                .filter(reservation -> reservation.getEndTimestamp().isAfter(now()))
                .collect(toList());
    }

    public RoomReservation saveRoomReservation(RoomReservation roomReservation) {
        return repository.save(roomReservation);
    }

    public void deleteRoomReservation(Long id) {
        repository.deleteById(id);
    }
}
