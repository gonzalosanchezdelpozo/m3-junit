package com.example.demo.junit.concepto5;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ciclo de vida JUnit
 * @BeforeAll una vez por clase, antes de todos los tests.
 * @AfterAll una vez por clase, después de todos los tests.
 */

public class LifeCycleClassTestEmployees {

    EmployeeServiceImpl service = new EmployeeServiceImpl();

    /**
     * Se ejecuta antes de cada método de test
     */
    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    /**
     * Se ejecuta después de cada método de test
     */
    @AfterAll
    static void afterAll(){
        System.out.println("afterAll");
    }

    @Test
    void countTest(){
        System.out.println("countTest");

        Integer num = service.count();

        assertNotNull(num);
        assertTrue(num > 0);
        assertEquals(3, num);

    }

    @Test
    void findAllTest(){
        System.out.println("findAllTest");
        List<SmartPhone> smartphones =  service.findAll();

        assertNotNull(smartphones);
        assertEquals(3, smartphones.size());
    }

}
