package com.smarttransit.transporttracker.controller;

import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.Bus;
import com.smarttransit.transporttracker.model.BusStop;
import com.smarttransit.transporttracker.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class BusStopController {

    @Autowired
    BusStopService busStopService;
    @PostMapping("/bus/stops")
    public ResponseEntity<BaseResponse> createBusStops(@RequestBody List<BusStop> buseStops){
        BaseResponse baseResponse = busStopService.createBusStop(buseStops);
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
    @DeleteMapping("/bus/stops")
    public ResponseEntity<BaseResponse> deleteBusStops(){
        BaseResponse baseResponse = busStopService.deleteBusStop();
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
}
