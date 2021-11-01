package com.example.demo.junit.concepto1;

import com.example.demo.domain.SmartPhone;
import com.example.demo.domain.Employee;
import com.example.demo.domain.SmartWatch;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.SmartPhoneServiceImpl;
import com.example.demo.service.SmartWatchServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Las aserciones permiten realizar comprobaciones sobre el código a testear.
 *
 * Si se cumplen las aserciones entonces el test es correcto y se ejecuta con éxito resultando en color verde.
 * Si no se cumplen las aserciones entonces el test es fallido y aparecerá en rojo
 */
public class AssertionsTest {

    @Test
    void countTest(){
        System.out.println("countTest SmartPhoneServiceImpl");

        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();

        Integer num = service.count();

        assertNotNull(num);
        assertTrue(num > 0);
        assertEquals(3, num);

    }

    @Test
    void countTest(){
        System.out.println("countTest EmployeeServiceImpl");

        EmployeeServiceImpl service = new EmployeeServiceImpl();

        Integer num = service.count();

        assertNotNull(num);
        assertTrue(num > 0);
        assertEquals(3, num);

    }

    @Test
    void countTest(){
        System.out.println("countTest SmartWatchServiceImpl");

        SmartWatchServiceImpl service = new SmartWatchServiceImpl();

        Integer num = service.count();

        assertNotNull(num);
        assertTrue(num > 0);
        assertEquals(3, num);

    }

    @Test
    void findAllTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        List<SmartPhone> smartphones =  service.findAll();

        assertNotNull(smartphones);
        assertEquals(3, smartphones.size());
    }

    @Test
    void findAllTest(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        List<Employee> employees =  service.findAll();

        assertNotNull(employees);
        assertEquals(3, employees.size());
    }

    @Test
    void findAllTest(){
        SmartWatchServiceImpl service = new SmartWatchServiceImpl();
        List<SmartWatch> smartwatches =  service.findAll();

        assertNotNull(smartwatches);
        assertEquals(3, smartwatches.size());
    }
}
