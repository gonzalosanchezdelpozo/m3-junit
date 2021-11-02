package com.example.demo.junit.concepto2;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeServiceImpl;

import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests operaciones CRUD con empleados")
public class DisplayNameTestEmpleados {

    @Test
    @DisplayName("Contar número de empleados")
    void countTest(){
        System.out.println("countTest");

        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Integer num = service.count();

        assertNotNull(num);
        assertTrue(num > 0);
        assertEquals(3, num);

    }

    @Test
    @DisplayName("Buscar todos los empleados")
    void findAllTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        List<Employee> smartphones =  service.findAll();

        assertNotNull(smartphones);
        assertEquals(3, smartphones.size());
    }




}
