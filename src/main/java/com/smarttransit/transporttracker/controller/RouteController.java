package com.smarttransit.transporttracker.controller;

import com.smarttransit.transporttracker.common.request.RoutesReq;
import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.BusStop;
import com.smarttransit.transporttracker.model.Route;
import com.smarttransit.transporttracker.repository.RouteRepository;
import com.smarttransit.transporttracker.service.BusStopService;
import com.smarttransit.transporttracker.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/bus")
@RestController
public class RouteController {

    @Autowired
    RouteService routeService;
    @PostMapping("/route")
    public ResponseEntity<BaseResponse> createBusStops(@RequestBody List<RoutesReq> routeList){
        BaseResponse baseResponse = routeService.createRoutes(routeList);
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
    @DeleteMapping("/route")
    public ResponseEntity<BaseResponse> deleteBusStops(){
        BaseResponse baseResponse = routeService.deleteRoutes();
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
}
