package com.isieiti.bdproject.mapper;

import com.isieiti.bdproject.dto.WardDTO;
import com.isieiti.bdproject.entity.Ward;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WardMapper {

    WardDTO toWardDTO(Ward ward);

    List<WardDTO> toWardDTOs(List<Ward> wardList);

    Ward toWard(WardDTO wardDTO);

}
