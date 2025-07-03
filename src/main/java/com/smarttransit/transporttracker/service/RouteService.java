package com.smarttransit.transporttracker.service;

import com.smarttransit.transporttracker.common.request.RoutesReq;
import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.BusStop;
import com.smarttransit.transporttracker.model.Route;

import java.util.List;

public interface RouteService {
    public BaseResponse createRoutes(List<RoutesReq> routeList);
    public BaseResponse deleteRoutes();
}
