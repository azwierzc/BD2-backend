package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.PerioperativeRoom;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.PerioperativeRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PerioperativeRoomService {

    private final PerioperativeRoomRepository repository;

    @Transactional(readOnly = true)
    public PerioperativeRoom findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PerioperativeRoom", "id", id));
    }
}
