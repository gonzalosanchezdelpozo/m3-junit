package com.example.demo.junit.concepto1;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Deshabilitar casos de test temporalmente debido a:
 * - nuevos desarrollos
 * - corrección de bugs / fallos
 * - ....
 *
 * Se utiliza @Disabled del test a deshabilitar
 */

public class DisabledTestEmployees {

    @Test
    void countTest(){
        System.out.println("countTest");

        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Integer num = service.count();

        assertNotNull(num);
        assertTrue(num > 0);
        assertEquals(3, num);

    }

    @DisplayName("Encontrar todos los empleados")
    @Disabled("Deshabilitado por bug #1324")
    @Test
    void findAllTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        List<Employee> employees =  service.findAll();

        assertNotNull(employees);
        assertEquals(3, employees.size());
    }

}
