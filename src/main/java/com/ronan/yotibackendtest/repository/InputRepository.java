package com.ronan.yotibackendtest.repository;


import com.ronan.yotibackendtest.model.Input;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InputRepository extends CrudRepository<Input, Long> {

    Optional<Input> findById(Long id);

}
