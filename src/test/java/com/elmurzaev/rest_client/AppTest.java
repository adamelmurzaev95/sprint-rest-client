package com.elmurzaev.rest_client;

import static org.junit.Assert.assertTrue;

import com.elmurzaev.rest_client.entity.Employee;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static Communication communication;

    @BeforeClass
    public static void init(){
        communication = new Communication(new RestTemplate());
    }

    @Test
    public void shouldEmployeesBeEqual()
    {
        Employee employee = new Employee("Adam", "Elmurzaev", "IT", 170000);
        employee.setId(4);
        Assert.assertEquals(employee, communication.show(4));
    }
}
