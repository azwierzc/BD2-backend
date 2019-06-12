package com.isieiti.bdproject.mapper;

import com.isieiti.bdproject.dto.InstrumentTypeDTO;
import com.isieiti.bdproject.entity.InstrumentType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstrumentTypeMapper {

    InstrumentTypeDTO toInstrumentTypeDTO(InstrumentType type);

    List<InstrumentTypeDTO> toInstrumentTypeDTOs(List<InstrumentType> instrumentTypes);

    InstrumentType toInstrumentType(InstrumentTypeDTO instrumentTypeDTO);
}
