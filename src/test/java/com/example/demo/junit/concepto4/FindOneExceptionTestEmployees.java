package com.example.demo.junit.concepto4;

import com.example.demo.domain.Employee;
import com.example.demo.domain.SmartPhone;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de tests para probar excepciones con aserciones.
 *
 * Se utiliza el método assertThrows
 */

public class FindOneExceptionTestEmployees {

    @Test
    void findOnePhone1Test() {

        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Employee employee1  = service.findOne(1L);

        assertNotNull(employee1);
        assertEquals(1L, employee1.getId());
        assertNotNull(employee1.getName());
    }

    @DisplayName("Comprobar que el empleado no existe")
    @Test
    void findOneEmployee999Test() {

        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Employee employee1  = service.findOne(999L);

        assertNull(employee1);
    }

    @DisplayName("Comprobar excepción al buscar un empleado nulo")
    @Test
    void findOneExceptionTest() {

        EmployeeServiceImpl service = new EmployeeServiceImpl();
        // verifica si se ha lanzado una excepción
        assertThrows(
                IllegalArgumentException.class,
                () -> service.findOne(null)
        );
    }

}
