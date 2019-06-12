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

import javax.validation.Valid;
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
    public InstrumentReservationPostDTO postInstrumentReservation(@RequestBody @Valid InstrumentReservationPostDTO instrumentReservationPostDTO) {

        LocalDateTime startTimeVer = instrumentReservationPostDTO.getStartTimestamp();
        LocalDateTime endTimeVer = instrumentReservationPostDTO.getEndTimestamp();
        instrumentReservationPostDTO.setStartTimestamp(startTimeVer.plusHours(2));
        instrumentReservationPostDTO.setEndTimestamp(endTimeVer.plusHours(2));

        //validation
        LocalDateTime startTime, endTime;
        startTime = instrumentReservationPostDTO.getStartTimestamp();
        endTime = instrumentReservationPostDTO.getEndTimestamp();
       // Instrument instrument = instrumentService.findById(instrumentReservationPostDTO.getInstrumentId());
        //List<InstrumentReservation> currentReservation = instrumentReservationService.getAllInstrumentReservationsByInstrument(instrument);

        if (endTime.isAfter(startTime) && endTime.isAfter(LocalDateTime.now()) && startTime.isAfter(LocalDateTime.now())) {
            Employee employee = employeeService.getSingleEmployee(instrumentReservationPostDTO.getEmployeeId());
            Instrument instrument2 = instrumentService.findById(instrumentReservationPostDTO.getInstrumentId());
            InstrumentReservation instrumentReservation = mapper.toInstrumentReservation(instrumentReservationPostDTO);
            instrumentReservation.setEmployee(employee);
            instrumentReservation.setInstrument(instrument2);
            return mapper.toInstrumentReservationPostDTO(instrumentReservationService.postInstrumentReservation(instrumentReservation));
        }

       /* currentReservation.forEach(reservation -> {
            if ((((startTime.isEqual(reservation.getStartTimestamp())) || (startTime.isAfter(reservation.getStartTimestamp())))
                    && ((startTime.isEqual(reservation.getEndTimestamp())) || (startTime.isBefore(reservation.getEndTimestamp()))))
                    || ((((endTime.isEqual(reservation.getStartTimestamp())) || (endTime.isAfter(reservation.getStartTimestamp()))))
                    && ((endTime.isEqual(reservation.getEndTimestamp())) || (endTime.isBefore(reservation.getEndTimestamp()))))) {

                throw new IllegalArgumentException("Rezewacja w wybranym terminie jest niemożliwa.");
            }
        });*/

        throw new IllegalArgumentException("Nieprawidłowe godziny rezerwacji!");
    }

    @DeleteMapping("/{id}")
    public void deleteInstrumentReservation(@PathVariable Long id) {
        instrumentReservationService.deleteInstrumentReservation(id);
    }
}
