package com.smarttransit.transporttracker.controller;

import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.Bus;
import com.smarttransit.transporttracker.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusController {
    @Autowired
    BusService busService;

    @PostMapping("/bus")
    public ResponseEntity<BaseResponse> createBuses(@RequestBody List<Bus> buses){
        BaseResponse baseResponse = busService.createBuses(buses);
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
    @GetMapping("/test")
    public String createBuses(){
        return "This is a test API";
    }
}
