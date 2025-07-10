package com.lbd.test.repository.impl;

import com.lbd.test.TestApplication;
import com.lbd.test.config.ConfigProperties;
import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class ListDataRepositorySpringTest {
    public static final String NAME = "NAME";
    public static final int ONE = 1;
    @InjectMocks
    private ListDataRepository rep;
    @Mock
    private List<DataDTO> employeeRep;

    @Mock
    private ConfigProperties props;

    @Test
    public void addEmployeeTest() {

        DataDTO employ = rep.addEmployee(createEmployee());


        // assertEquals("list", employ.getImpl());
        assertNotNull(employ.getId());

    }

    private EmployeeDTO createEmployee() {
        return EmployeeDTO.builder()
                .name(NAME)
                .experience(ONE)
                .active(true)
                .build();
    }


}
