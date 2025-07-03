package com.smarttransit.transporttracker.service.impl;

import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.Bus;
import com.smarttransit.transporttracker.repository.BusRepository;
import com.smarttransit.transporttracker.repository.RouteRepository;
import com.smarttransit.transporttracker.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    BusRepository busRepository;
    @Autowired
    RouteRepository routeRepository;
    @Override
    public BaseResponse createBuses(List<Bus> buses) {
        for(Bus bus : buses){
            Optional<Bus> optionalBus = busRepository.findByBusNumber(bus.getBusNumber());
            if(optionalBus.isEmpty()) busRepository.save(bus);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setMessage("Buses are added");
        baseResponse.setSuccess(true);
        return baseResponse;
    }
    @Override
    public BaseResponse deleteBuses(List<Bus> buses) {
        for(Bus bus : buses){
            busRepository.delete(bus);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setMessage("Buses are deleted");
        baseResponse.setSuccess(true);
        return baseResponse;
    }
}
