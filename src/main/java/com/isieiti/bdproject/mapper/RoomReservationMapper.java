package com.isieiti.bdproject.mapper;

import com.isieiti.bdproject.dto.RoomReservationDTO;
import com.isieiti.bdproject.dto.RoomReservationPostDTO;
import com.isieiti.bdproject.entity.RoomReservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RoomReservationMapper {

    @Mappings({
            @Mapping(target = "employeeId", source = "roomReservation.employee.id"),
            @Mapping(target = "employeeName", source = "roomReservation.employee.name"),
            @Mapping(target = "employeeSurname", source = "roomReservation.employee.surname"),
            @Mapping(target = "employeeType", source = "roomReservation.employee.type"),
            @Mapping(target = "roomId", source = "roomReservation.room.id"),
            @Mapping(target = "roomNumber", source = "roomReservation.room.number"),
            @Mapping(target = "roomType", source = "roomReservation.room.type"),
            @Mapping(target = "employeePrefix", source = "roomReservation.employee.prefix")
    })
    public abstract RoomReservationDTO toRoomReservationDTO(RoomReservation roomReservation);

    @Mappings({
            @Mapping(target = "employeeId", source = "employee.id"),
            @Mapping(target = "roomId", source = "room.id")
    })
    public abstract RoomReservationPostDTO toRoomReservationPostDTO(RoomReservation roomReservation);

    public abstract List<RoomReservationDTO> toRoomReservationDTOs(List<RoomReservation> roomReservations);

    @Mappings({
            @Mapping(target = "room.id", source = "roomId"),
            @Mapping(target = "employee.id", source = "employeeId"),
    })
    public abstract RoomReservation toRoomReservation(RoomReservationPostDTO roomReservationPostDTO);
}
