package com.isieiti.bdproject.controller;

import com.isieiti.bdproject.dto.RoomReservationDTO;
import com.isieiti.bdproject.dto.RoomReservationPostDTO;
import com.isieiti.bdproject.entity.Employee;
import com.isieiti.bdproject.entity.Room;
import com.isieiti.bdproject.entity.RoomReservation;
import com.isieiti.bdproject.mapper.RoomReservationMapper;
import com.isieiti.bdproject.service.EmployeeService;
import com.isieiti.bdproject.service.RoomReservationService;
import com.isieiti.bdproject.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room_reservation")
public class RoomReservationController {

    private final RoomReservationMapper mapper;
    private final EmployeeService employeeService;
    private final RoomService roomService;
    private final RoomReservationService roomReservationService;

    @GetMapping("/{id}")
    public RoomReservationDTO getRoomReservationById(@PathVariable Long id) {
        return mapper.toRoomReservationDTO(roomReservationService.findById(id));
    }

    @GetMapping
    public List<RoomReservationDTO> getRoomReservations() {
        return mapper.toRoomReservationDTOs(roomReservationService.getAllRoomReservations());
    }

    @PostMapping
    public RoomReservationPostDTO postRoomReservation(@RequestBody @Valid RoomReservationPostDTO roomReservationPostDTO) {

        //validation
        LocalDateTime startTime, endTime;
        startTime = roomReservationPostDTO.getStartTimestamp();
        endTime = roomReservationPostDTO.getEndTimestamp();

        if(endTime.isAfter(startTime) && endTime.isAfter(LocalDateTime.now()) && startTime.isAfter(LocalDateTime.now())){
            Employee employee = employeeService.getSingleEmployee(roomReservationPostDTO.getEmployeeId());
            Room room = roomService.findById(roomReservationPostDTO.getRoomId());
            RoomReservation roomReservation = mapper.toRoomReservation(roomReservationPostDTO);
            roomReservation.setEmployee(employee);
            roomReservation.setRoom(room);
            return mapper.toRoomReservationPostDTO(roomReservationService.saveRoomReservation(roomReservation));
        }

        throw new IllegalArgumentException("Nieprawidłowe godziny rezerwacji!");
    }

    @DeleteMapping("/{id}")
    public void deleteRoomReservation(@PathVariable Long id) {
        roomReservationService.deleteRoomReservation(id);
    }
}
