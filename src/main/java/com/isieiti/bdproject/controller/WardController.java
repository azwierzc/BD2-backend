package com.isieiti.bdproject.controller;

import com.isieiti.bdproject.dto.WardDTO;
import com.isieiti.bdproject.entity.Ward;
import com.isieiti.bdproject.mapper.WardMapper;
import com.isieiti.bdproject.service.WardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wards")
public class WardController {

    private final WardService service;
    private final WardMapper mapper;

    @GetMapping
    public List<WardDTO> getAllWards() {
        return mapper.toWardDTOs(service.getAllWards());
    }

    @GetMapping("/{id}")
    public WardDTO getWard(@PathVariable Long id) {
        return mapper.toWardDTO(service.findById(id));
    }

    @PostMapping
    public WardDTO addWard(@RequestBody WardDTO wardDTO) {
        List<Ward> wards = service.getAllWards();
        for(Ward ward : wards){

            if(ward.getName().equals(wardDTO.getName())){
                return null;
            }
        }
        return mapper.toWardDTO(service.addWard(mapper.toWard(wardDTO)));
    }

    @DeleteMapping("/{id}")
    public void deleteWard(@PathVariable Long id) {
        service.deleteWard(id);
    }
}
