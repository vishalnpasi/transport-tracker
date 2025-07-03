package com.smarttransit.transporttracker.service;

import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.Bus;
import com.smarttransit.transporttracker.model.BusStop;

import java.util.List;

public interface BusStopService {
    public BaseResponse createBusStop(List<BusStop> busStopList);
    public BaseResponse deleteBusStop();
}
