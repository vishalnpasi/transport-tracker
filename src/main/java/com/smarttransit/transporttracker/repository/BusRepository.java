package com.smarttransit.transporttracker.repository;

import com.smarttransit.transporttracker.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BusRepository extends MongoRepository<Bus,String> {
    Optional<Bus> findByBusNumber(String BusNumber);
}
