package com.smarttransit.transporttracker.repository;

import com.smarttransit.transporttracker.model.BusStop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface BusStopRepository extends MongoRepository<BusStop, String> {

    Optional<BusStop> findByStopName(String stopName);

}
