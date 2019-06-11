package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.Room;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repository;

    @Transactional(readOnly = true)
    public Room findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ward", "id", id));
    }

    @Transactional(readOnly = true)
    public List<Room> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Room addRoom(Room room) {
        return repository.save(room);
    }

    @Transactional
    public void deleteRoom(Long id) {
        repository.deleteById(id);
    }
}
