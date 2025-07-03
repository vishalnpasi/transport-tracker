package com.smarttransit.transporttracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "routes")
public class Route {
    @Id
    private String id;
    private String routeName;
    private List<BusStop> stops = new ArrayList<>();
}
