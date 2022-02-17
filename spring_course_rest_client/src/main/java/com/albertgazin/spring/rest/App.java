package com.albertgazin.spring.rest;

import com.albertgazin.spring.rest.configuration.MyConfig;
import com.albertgazin.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee employee = communication.getEmployee(1);
//        System.out.println(employee);

//        Employee emp = new Employee("Sveta", "Sokolova", "Sales", 1200);
//        emp.setId(5);
//        communication.saveEmployee(emp);

        communication.deleteEmployee(5);

    }
}
