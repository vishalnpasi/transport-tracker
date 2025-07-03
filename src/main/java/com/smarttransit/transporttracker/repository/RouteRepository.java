package com.smarttransit.transporttracker.repository;

import com.smarttransit.transporttracker.model.Bus;
import com.smarttransit.transporttracker.model.BusStop;
import com.smarttransit.transporttracker.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RouteRepository extends MongoRepository<Route, String> {
//    Optional<Route> findById(String Id);
}
