package com.register.repository;

import com.register.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<RegisterEntity, Long> {
}
