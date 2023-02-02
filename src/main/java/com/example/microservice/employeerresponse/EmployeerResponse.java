package com.example.microservice.employeerresponse;

import com.example.microservice.addressresponse.AdrressResponse;
import com.example.microservice.modelemployeer.Employeer;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // if we does not annotate @Component. spring can't configure automatically or create bean for class.
@Data
public class EmployeerResponse {

    private String name;
    private Optional<Employeer> Employeeresponse;
    private AdrressResponse Adressresponse;
    //RestTemplate's methods such as getForEntity() returns a ResponseEntity object,
    // which represents the HTTP response, including the body and headers.
    // The ResponseEntity class has a generic type parameter, <T>,
    // that specifies the type of the response body.
}

