package com.example.demo.junit.concepto8;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test funcionalidad CRUD sobre smartphones")
public class EmployeesCRUDTest {

    @DisplayName("Crear / Actualizar empleados")
    @Nested
    class SaveTest{
        @DisplayName("Comprobar excepción cuando el smartphone a guardar es nulo")
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

            Employee employee = new employee (null, "Francisco Iglesias", 44);

            assertEquals(3, service.count());
            Employee result = service.save(employee);
            assertEquals(4, service.count());
            assertNotNull(result);
            assertNotNull(result.getId());
            assertEquals(4, result.getId());

        }
        @DisplayName("Comprobar que se asigna un id cuando el id que pasamos es 0")
        @Test
        void saveIdZeroTest(){
            EmployeeServiceImpl service = new EmployeeServiceImpl();
            Employee employee = new Employee(0L, "Pepe Gotera", 55);

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

            Employee employee = new Employee (1L, "Pepe Gotera", 55);

            // comprobar num smartphones
            assertEquals(3, service.count());
            Employee result = service.save(employee);
            assertEquals(3, service.count()); // no se crea un empleado, se actualiza uno que ya existe

            // comprobar id
            assertEquals(1L, result.getId());

            // comprobar name
            Employee employee1 = service.findOne(1L);
            assertEquals("Pepe Gotera", employee1.getName());

        }
        @DisplayName("Comprobar id negativo, no se debería añadir un empleados")
        @Test
        void saveNegativeIdTest(){
            EmployeeServiceImpl service = new EmployeeServiceImpl();

            Employee employee = new Employee( -2L, "Alberto Chicote", 55);


            assertEquals(3, service.count());

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.save(employee)
            );

            assertEquals(3, service.count());


        }
    }

    @DisplayName("Recuperar empleado")
    @Nested
    class RetrieveTest{

        @Test
        void countTest(){
            System.out.println("countTest");

            EmployeeServiceImpl service = new EmployeeServiceImpl();

            Integer num = service.count();

            assertNotNull(num);
            assertTrue(num > 0);
            assertEquals(3, num);

        }

        @Test
        void findAllTest(){
            EmployeeServiceImpl service = new EmployeeServiceImpl();
            List<Employee> employees =  service.findAll();

            assertNotNull(employees);
            assertEquals(3, employees.size());
        }

        @Test
        void findOneEmpleado1Test() {

            EmployeeServiceImpl service = new EmployeeServiceImpl();

            Employee empleado1  = service.findOne(1L);

            assertNotNull(empleado1);
            assertEquals(1L, empleado1.getId());
            assertNotNull(empleado1.getName());
        }

        @DisplayName("Comprobar que el empleado no existe")
        @Test
        void BuscaUnEmpleado999Test() {

            EmployeeServiceImpl service = new EmployeeServiceImpl();

            Employee empleado1  = service.findOne(999L);

            assertNull(empleado1);
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

    @DisplayName("Borrar un empleado")
    @Nested
    class DeleteTest{
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

}
