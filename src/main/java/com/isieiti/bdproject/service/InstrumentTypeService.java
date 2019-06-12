package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.InstrumentType;
import com.isieiti.bdproject.entity.Ward;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.InstrumentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstrumentTypeService {

    private final InstrumentTypeRepository repository;


    @Transactional(readOnly = true)
    public List<InstrumentType> getAllInstrumentTypes() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public InstrumentType findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("InstrumentType", "id", id));
    }

    @Transactional
    public InstrumentType addInstrumentType(InstrumentType instrumentType) {
        return repository.save(instrumentType);
    }

    @Transactional
    public void deleteInstrumentType(Long id) {
        repository.deleteById(id);
    }

}
