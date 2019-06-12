package com.isieiti.bdproject.controller;

import com.isieiti.bdproject.dto.RoomDTO;
import com.isieiti.bdproject.entity.Room;
import com.isieiti.bdproject.mapper.RoomMapper;
import com.isieiti.bdproject.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    private final RoomMapper mapper;

    @GetMapping
    public List<RoomDTO> getRoomsList() {
        return mapper.toRoomDTOs(service.getAll());
    }

    @GetMapping("/{id}")
    public RoomDTO getOneRoom(@PathVariable Long id) {
        return mapper.toRoomDTO(service.findById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN') AND hasAuthority('MAINTAINER')")
    @PostMapping
    public RoomDTO addRoom(@RequestBody RoomDTO dto) {
        return mapper.toRoomDTO(service.addRoom(mapper.toRoom(dto)));
    }

    @PreAuthorize("hasAuthority('ADMIN') AND hasAuthority('MAINTAINER')")
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        service.deleteRoom(id);
    }
}
