package com.smarttransit.transporttracker.service.impl;

import com.smarttransit.transporttracker.model.Bus;
import com.smarttransit.transporttracker.model.Route;
import com.smarttransit.transporttracker.repository.BusRepository;
import com.smarttransit.transporttracker.repository.RouteRepository;
import com.smarttransit.transporttracker.service.BusSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BusSimulationServiceImpl implements BusSimulationService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Scheduled(fixedRate = 15000)   // Every 15 seconds
    public void simulatieBusMovement() {
        List<Bus> buses = busRepository.findAll();
        for(Bus bus : buses){
            Optional<Route> optionalRoute = routeRepository.findById(bus.getRouteId());
            if(!optionalRoute.isEmpty()) {
                Route route = optionalRoute.get();
                if (route.getStops() == null || route.getStops().size() == 0) continue;

                int nextIndex = (bus.getCurrentStopIndex() + 1) % route.getStops().size();
                bus.setCurrentStopIndex(nextIndex);
                bus.setLastUpdated(LocalDateTime.now());
                busRepository.save(bus);
            }
        }
    }
}
