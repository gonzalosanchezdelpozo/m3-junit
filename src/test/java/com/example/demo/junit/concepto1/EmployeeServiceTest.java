package com.example.demo.junit.concepto1;

import com.example.demo.domain.Employee;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeServiceTest {

    @DisplayName("Comprobar excepción cuando el empleado a guardar es nulo")
    @Test
    void saveNullTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.save(null)
        );
    }

    @DisplayName("Comprobar que se asigna un id cuando el id que pasamos es null")
    @Test
    void saveIdNullTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Employee employee = new Employee(null, "Javier Álvarez", 55);

        assertEquals(3, service.count());
        SmartPhone result = service.save(employee);
        assertEquals(4, service.count());
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(4, result.getId());

    }
    @DisplayName("Comprobar que se asigna un id cuando el id que pasamos es 0")
    @Test
    void saveIdZeroTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Employee employee = new Employee(0L, "Francisco Armendariz", 44);
                );

        assertEquals(3, service.count());
        Employee result = service.save(employee);
        assertEquals(4, service.count());
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(4, result.getId());
    }

    @DisplayName("Comprobar que se actualiza un empleado existente")
    @Test
    void saveUpdateTest(){

        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Employee employee = new Employee(1L, "Alberto Alcocer", 44);

        // comprobar num empleados
        assertEquals(3, service.count());
        long result = service.save(employee);
        assertEquals(3, service.count()); // no se crea un empleado, se actualiza uno que ya existe

        // comprobar id
        assertEquals(1L, result.getId());

        // comprobar name
        Employee empleado1 = service.findOne(1L);
        assertEquals("One plus 9 editado", empleado1.getName());

    }
    @DisplayName("Comprobar id negativo, no se debería añadir un smartphone")
    @Test
    void saveNegativeIdTest(){
        holaMundo();

        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Employee employee = new Employee(-4L, "Juan Dos", 31);


        assertEquals(3, service.count());

        assertThrows(
                IllegalArgumentException.class,
                () -> service.save(employee)
        );

        assertEquals(3, service.count());


    }

    private void holaMundo(){
        System.out.println("Hola mundo");
    }

    @Test
    void deleteNullTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        boolean result = service.delete(null);
        assertFalse(result);
    }

    @Test
    void deleteNotContainsTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        boolean result = service.delete(666L);
        assertFalse(result);
    }

    @Test
    void deleteOkTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        boolean result = service.delete(1L);
        assertTrue(result);
    }

    @Test
    void deleteAllTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        assertTrue(service.count() > 0);
        service.deleteAll();
        assertEquals(0, service.count());

    }

}
