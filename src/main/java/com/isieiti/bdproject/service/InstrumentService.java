package com.isieiti.bdproject.service;

import com.isieiti.bdproject.entity.Instrument;
import com.isieiti.bdproject.exception.ResourceNotFoundException;
import com.isieiti.bdproject.repository.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstrumentService {

    private final InstrumentRepository repository;

    @Transactional(readOnly = true)
    public Instrument findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instrument", "id", id));
    }

    @Transactional(readOnly = true)
    public List<Instrument> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Instrument saveInstrument(Instrument instrument) {
        return repository.save(instrument);
    }

    @Transactional
    public void deleteInstrument(Long id) {
        repository.deleteById(id);
    }
}
