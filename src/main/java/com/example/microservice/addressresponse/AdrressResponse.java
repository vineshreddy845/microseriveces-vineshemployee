package com.example.microservice.addressresponse;

//import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AdrressResponse {
   // private Long id; // I don't want show id values to client. so that i commented.
    private String country;
    private String villagename;
    private String mandal;

}
