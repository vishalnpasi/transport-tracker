package com.smarttransit.transporttracker.service.impl;

import com.smarttransit.transporttracker.common.request.RoutesReq;
import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.BusStop;
import com.smarttransit.transporttracker.model.Route;
import com.smarttransit.transporttracker.repository.BusStopRepository;
import com.smarttransit.transporttracker.repository.RouteRepository;
import com.smarttransit.transporttracker.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    BusStopRepository busStopRepository;
    @Override
    public BaseResponse createRoutes(List<RoutesReq> routeReqList) {
        List<Route> routeList = new ArrayList<>();
        for(RoutesReq routeReq : routeReqList){
            Route route = new Route();
            route.setRouteName(routeReq.getRouteName());
            List<BusStop> busStopList = routeReq.getStops().stream()
                    .map(busStopRepository::findByStopName)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            route.setStops(busStopList);
            routeList.add(routeRepository.save(route));
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setMessage("Routes are added");
        baseResponse.setSuccess(true);
        baseResponse.setPayload(routeList);
        return baseResponse;
    }
    @Override
    public BaseResponse deleteRoutes() {
        routeRepository.deleteAll();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setMessage("Routes  are deleted");
        baseResponse.setSuccess(true);
        return baseResponse;
    }
}
