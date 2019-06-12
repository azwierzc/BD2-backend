package com.isieiti.bdproject.controller;

import com.isieiti.bdproject.dto.InstrumentTypeDTO;
import com.isieiti.bdproject.mapper.InstrumentTypeMapper;
import com.isieiti.bdproject.service.InstrumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/instrument_type")
public class InstrumentTypeController {

    private final InstrumentTypeService service;
    private final InstrumentTypeMapper mapper;

    @GetMapping
    public List<InstrumentTypeDTO> getAllInstrumentTypes() {
        return mapper.toInstrumentTypeDTOs(service.getAllInstrumentTypes());
    }

    @GetMapping("/{id}")
    public InstrumentTypeDTO getInstrumentType(@PathVariable Long id) {
        return mapper.toInstrumentTypeDTO(service.findById(id));
    }

    @PostMapping
    public InstrumentTypeDTO addWard(@RequestBody InstrumentTypeDTO instrumentTypeDTO) {
        return mapper.toInstrumentTypeDTO(service.addInstrumentType(mapper.toInstrumentType(instrumentTypeDTO)));
    }

    @DeleteMapping("/{id}")
    public void deleteWard(@PathVariable Long id) {
        service.deleteInstrumentType(id);
    }
}
