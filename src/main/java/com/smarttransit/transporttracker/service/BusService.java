package com.smarttransit.transporttracker.service;

import com.smarttransit.transporttracker.common.response.BaseResponse;
import com.smarttransit.transporttracker.model.Bus;

import java.util.List;

public interface BusService {
    public BaseResponse createBuses(List<Bus> buses);
    public BaseResponse deleteBuses(List<Bus> buses);
}
