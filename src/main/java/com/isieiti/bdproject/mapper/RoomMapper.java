package com.isieiti.bdproject.mapper;

import com.isieiti.bdproject.dto.RoomDTO;
import com.isieiti.bdproject.entity.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    List<RoomDTO> toRoomDTOs(List<Room> rooms);

    RoomDTO toRoomDTO(Room room);

    Room toRoom(RoomDTO roomDTO);
}
