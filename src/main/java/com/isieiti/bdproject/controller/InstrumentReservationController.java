package com.isieiti.bdproject.controller;

import com.isieiti.bdproject.dto.InstrumentReservationDTO;
import com.isieiti.bdproject.dto.InstrumentReservationPostDTO;
import com.isieiti.bdproject.entity.Employee;
import com.isieiti.bdproject.entity.Instrument;
import com.isieiti.bdproject.entity.InstrumentReservation;
import com.isieiti.bdproject.mapper.InstrumentReservationMapper;
import com.isieiti.bdproject.service.EmployeeService;
import com.isieiti.bdproject.service.InstrumentReservationService;
import com.isieiti.bdproject.service.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instrument_reservation")
public class InstrumentReservationController {

    private final InstrumentReservationMapper mapper;
    private final InstrumentReservationService instrumentReservationService;
    private final InstrumentService instrumentService;
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public InstrumentReservationDTO getInstrumentReservationById(@PathVariable Long id) {
        return mapper.toInstrumentReservationDTO(instrumentReservationService.findById(id));
    }

    @GetMapping
    public List<InstrumentReservationDTO> getInstrumentReservations() {
        return mapper.toInstrumentReservationDTOs(instrumentReservationService.getAllInstrumentReservations());
    }

    @PostMapping
    public InstrumentReservationPostDTO postInstrumentReservation(@RequestBody InstrumentReservationPostDTO instrumentReservationPostDTO) {

        //validation
        LocalDateTime startTime, endTime;
        startTime = instrumentReservationPostDTO.getStartTimestamp();
        endTime = instrumentReservationPostDTO.getEndTimestamp();

        if(endTime.isAfter(startTime) && endTime.isAfter(LocalDateTime.now()) && startTime.isAfter(LocalDateTime.now())){
            Employee employee = employeeService.getSingleEmployee(instrumentReservationPostDTO.getEmployeeId());
            Instrument instrument = instrumentService.findById(instrumentReservationPostDTO.getInstrumentId());
            InstrumentReservation instrumentReservation = mapper.toInstrumentReservation(instrumentReservationPostDTO);
            instrumentReservation.setEmployee(employee);
            instrumentReservation.setInstrument(instrument);
            return mapper.toInstrumentReservationPostDTO(instrumentReservationService.postInstrumentReservation(instrumentReservation));
        }

        return null;
    }

    @DeleteMapping
    public void deleteInstrumentReservation(@PathVariable Long id) {
        instrumentReservationService.deleteInstrumentReservation(id);
    }
}
