package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.Ward;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.WardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WardService {

    private final WardRepository repository;

    @Transactional(readOnly = true)
    public List<Ward> getAllWards() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Ward findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ward", "id", id));
    }

    @Transactional
    public Ward addWard(Ward ward) {
        return repository.save(ward);
    }

    @Transactional
    public void deleteWard(Long id) {
        repository.deleteById(id);
    }
}
