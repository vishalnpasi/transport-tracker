package com.smarttransit.transporttracker.common.request;

import lombok.Data;

import java.util.List;

@Data
public class RoutesReq {
    String routeName;
    List<String> stops;
}
