package com.example.demo.junit.concepto8;

package com.example.demo.junit.concepto8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Los tests anidados.
 *
 * Clases de test dentro de otras clases con el objetivo de agrupar métodos de tests
 * por categoría o temática.
 *
 * La anotación @Nested sobre una clase interna indica que serán tests anidados
 */
@DisplayName("Operaciones CRUD sobre empleados")

public class NestedTestEmployees {

    @DisplayName("Funcionalidad buscar sobre empleados")
    @Nested
    class RetrieveTests {

        @DisplayName("findOne - Buscar 1 empleado")
        @Test
        public void test1(){
        }

        @DisplayName("findAll - Buscar todos los empleados")
        @Test
        public void test2(){
        }

    }

    @DisplayName("Funcionalidad crear y modificar sobre empleados")
    @Nested
    class SaveTests {

        @DisplayName("create - Crear un empleado")
        @Test
        public void test1(){
        }

        @DisplayName("update - Actualizar un empleado existente")
        @Test
        public void test2(){
        }
    }

}
