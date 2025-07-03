package com.smarttransit.transporttracker.service.impl;

import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.Bus;
import com.smarttransit.transporttracker.model.BusStop;
import com.smarttransit.transporttracker.repository.BusRepository;
import com.smarttransit.transporttracker.repository.BusStopRepository;
import com.smarttransit.transporttracker.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusStopServiceImpl implements BusStopService {
    @Autowired
    BusStopRepository busStopRepository;
    @Override
    public BaseResponse createBusStop(List<BusStop> busStopList) {
        for(BusStop busStop : busStopList){
            busStopRepository.save(busStop);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setMessage("Bus Stops are added");
        baseResponse.setSuccess(true);
        return baseResponse;
    }
    @Override
    public BaseResponse deleteBusStop() {
        List<BusStop> busStopList = busStopRepository.findAll();
        for(BusStop busStop : busStopList){
            busStopRepository.delete(busStop);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setMessage("Buse Stops are deleted");
        baseResponse.setSuccess(true);
        return baseResponse;
    }
}
