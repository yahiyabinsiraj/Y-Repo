package com.example.microservice.collection.exception.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {

    public Integer errorCode;
    public String message;
    public String traceId;
    public LocalDateTime timestamp;

}
