package com.elmurzaev.rest_client;

import com.elmurzaev.rest_client.config.MyConfig;
import com.elmurzaev.rest_client.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        /*List<Employee> employeeList = communication.index();
        System.out.println(employeeList);*/
        /*Employee employee = communication.show(4);
        System.out.println(employee);*/
        Employee employee = new Employee("Muslim", "Mazhiev", "IT", 92500);
        communication.save(employee);
        System.out.println(communication.index());
    }
}
