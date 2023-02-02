package com.example.microservice.contoller;

import com.example.microservice.addressresponse.AdrressResponse;
import com.example.microservice.employeerresponse.EmployeerResponse;
import com.example.microservice.modelemployeer.Employeer;
import com.example.microservice.repositoryemployeer.RepositoryEmployyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class contoller {
    @Autowired
    private RepositoryEmployyer repo;
    @Autowired
    private EmployeerResponse response;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AdrressResponse adressresponse;

    @PostMapping("/map")
    public Employeer emp(@RequestBody Employeer empq){
        return repo.save(empq);
    }
    @GetMapping("/delete")
    public void empo(Employeer emp){
        repo.deleteAll();
    }

    @GetMapping("/deleteid")
 public void delete(@RequestBody Employeer emp)
 {
     repo.deleteById(emp.id);
 }
// @GetMapping("/employee/{id}")
// public EmployeerResponse em(@PathVariable(value="id") Long id){
//       // response.setName("Employeeresponse");
//    //  response.setEmployeeresponse(repo.findById(id));
//     Logger logger = LoggerFactory.getLogger(this.getClass());
//     logger.info("Getting employee with id: {}", id);
//     response.setName("Employeeresponse");
//     response.setEmployeeresponse(repo.findById(id));
//     logger.info("Getting Addressresponse with id: {}", id);
//     response.setAdressresponse(restTemplate.getForObject("http://localhost:8081/response/{id}",AdrressResponse.class, id));
//     if(response.getAdressresponse() == null) {
//         logger.error("unable to get Addressresponse with id: {}", id);
//     }
//    //response.setAdressresponse(restTemplate.getForObject("http://localhost:8081/response/{id}",AdrressResponse.class, id));
//     //response.setAdressresponse(adressresponse.set);
//      return  response;
// }
//@GetMapping("/employee/{id}")
//public EmployeerResponse em(@PathVariable(value="id") Long id){
//   // Logger logger = LoggerFactory.getLogger(this.getClass());
//    response.setName("Employeeresponse");
//   // logger.info("Getting employee with id: " + id);
//    response.setEmployeeresponse(repo.findById(id));
//   // logger.info("Getting address for employee with id: " + id);
//    response.setAdressresponse(restTemplate.getForObject("http://localhost:8081/response/{id}",AdrressResponse.class, id));
//   // logger.info("Completed getting address for employee with id: " + id);
//    return  response;
//}
    @GetMapping("/what/{id}")
    public ResponseEntity <AdrressResponse> resp(@PathVariable(value="id")Long id) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Calling address service with id: {}", id);
        ResponseEntity<AdrressResponse> rp= restTemplate.getForEntity("http://localhost:8081/response/{id}", AdrressResponse.class, id);
        return rp;
    }

    @GetMapping("/string")
    public String av(){
      String y=  restTemplate.getForObject("http://localhost:8081/ops", String.class);
      return y;
    }
    @GetMapping("/whats/{id}")
    public EmployeerResponse resps(@PathVariable(value="id") Long id) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Calling address service with id: {}", id);
        response.setName("we called https method or api of other microservice using restTemplate");
        response.setEmployeeresponse(repo.findById(id));

        response.setAdressresponse(restTemplate.getForObject("http://localhost:8081/want/{id}", AdrressResponse.class,id));
        return response;
    }


}
