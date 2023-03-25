package com.tng.rfid.repository;

import com.tng.rfid.entity.ContactConfig;
import org.springframework.data.repository.CrudRepository;

public interface DingTalkContactRepository extends CrudRepository<ContactConfig, Integer> {
}
