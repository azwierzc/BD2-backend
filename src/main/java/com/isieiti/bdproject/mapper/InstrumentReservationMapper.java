package com.isieiti.bdproject.mapper;

import com.isieiti.bdproject.dto.InstrumentReservationDTO;
import com.isieiti.bdproject.dto.InstrumentReservationPostDTO;
import com.isieiti.bdproject.entity.InstrumentReservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class InstrumentReservationMapper {

    @Mappings({
            @Mapping(target = "employeeId", source = "employee.id"),
            @Mapping(target = "employeeName", source = "employee.name"),
            @Mapping(target = "employeeSurname", source = "employee.surname"),
            @Mapping(target = "employeeType", source = "employee.type"),
            @Mapping(target = "instrumentId", source = "instrument.id"),
            @Mapping(target = "serialNumber", source = "instrument.serialNumber"),
            @Mapping(target = "instrumentType", source = "instrument.type")
    })
    public abstract InstrumentReservationDTO toInstrumentReservationDTO(InstrumentReservation instrumentReservation);

    @Mappings({
            @Mapping(target = "employeeId", source = "employee.id"),
            @Mapping(target = "instrumentId",source = "instrument.id")
    })
    public abstract InstrumentReservationPostDTO toInstrumentReservationPostDTO(InstrumentReservation instrumentReservation);

    public abstract List<InstrumentReservationDTO> toInstrumentReservationDTOs(List<InstrumentReservation> instrumentReservations);

    @Mappings({
            @Mapping(target = "employee.id", source = "employeeId"),
            @Mapping(target = "instrument.id", source = "instrumentId")
    })
    public abstract InstrumentReservation toInstrumentReservation(InstrumentReservationPostDTO instrumentReservationPostDTO);
}
