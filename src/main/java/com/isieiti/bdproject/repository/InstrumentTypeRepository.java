package com.isieiti.bdproject.repository;

import com.isieiti.bdproject.entity.InstrumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentTypeRepository extends JpaRepository<InstrumentType, Long> {
}
