package com.smarttransit.transporttracker.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    boolean success;
    String message;
    HttpStatus httpStatus;
    Object payload;
}
