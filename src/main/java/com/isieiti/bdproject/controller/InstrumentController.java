package com.isieiti.bdproject.controller;

import com.isieiti.bdproject.dto.InstrumentDTO;
import com.isieiti.bdproject.mapper.InstrumentMapper;
import com.isieiti.bdproject.service.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruments")
@RequiredArgsConstructor
public class InstrumentController {

    private final InstrumentService service;

    private final InstrumentMapper mapper;

    @GetMapping
    public List<InstrumentDTO> getInstruments() {
        return mapper.toInstrumentDTOs(service.getAll());
    }

    @GetMapping("/{id}")
    public InstrumentDTO getOneInstrument(@PathVariable Long id) {
        return mapper.toInstrumentDTO(service.findById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN') AND hasAuthority('MAINTAINER')")
    @PostMapping
    public InstrumentDTO postInstrument(@RequestBody InstrumentDTO instrumentDTO) {
        return mapper.toInstrumentDTO(service.saveInstrument(mapper.toInstrument(instrumentDTO)));
    }

    @PreAuthorize("hasAuthority('ADMIN') AND hasAuthority('MAINTAINER')")
    @DeleteMapping("/{id}")
    public void deleteInstrument(@PathVariable Long id) {
        service.deleteInstrument(id);
    }
}
