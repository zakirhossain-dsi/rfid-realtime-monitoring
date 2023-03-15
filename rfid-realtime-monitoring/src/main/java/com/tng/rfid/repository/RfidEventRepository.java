package com.tng.rfid.repository;

import com.tng.rfid.entity.RfidEvent;
import org.springframework.data.repository.CrudRepository;

public interface RfidEventRepository extends CrudRepository<RfidEvent, Integer> {
}
