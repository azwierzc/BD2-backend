package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.Ward;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.WardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WardService {

    private final WardRepository repository;

    public List<Ward> getAllWards() {
        return repository.findAll();
    }

    public Ward findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ward", "id", id));
    }
}
