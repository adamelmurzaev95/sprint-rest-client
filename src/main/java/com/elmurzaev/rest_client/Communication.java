package com.elmurzaev.rest_client;

import com.elmurzaev.rest_client.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/employees";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> index(){
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> employees = responseEntity.getBody();
        return employees;
    }

    public Employee show(int id){
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void save(Employee employee){
        int id = employee.getId();
        if (id == 0){
            ResponseEntity<Employee> responseEntity =
                    restTemplate.postForEntity(URL, employee, Employee.class);
            System.out.println("New Employee was added to database");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with id = " + id + " was edited");
        }
    }

    public void delete(int id){
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with id = " + id + " was deleted");
    }
}
