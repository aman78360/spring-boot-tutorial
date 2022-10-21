package com.aman.springboot.tutorial.repository;

import com.aman.springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("EE")
                .departmentCode("EE-01")
                .departmentAddress("Delhi").build();

        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department found = departmentRepository.findById(1L).get();

        assertEquals(found.getDepartmentName(), "EE");
    }
}