package com.smarttransit.transporttracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.RouteMatcher;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "buses")
public class Bus {
    @Id
    private  String id;
    private String busNumber;
    private String routeId;
    private  int currentStopIndex;
    private LocalDateTime lastUpdated;
}
