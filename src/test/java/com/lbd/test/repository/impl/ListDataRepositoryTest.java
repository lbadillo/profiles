package com.lbd.test.repository.impl;

import com.lbd.test.config.ConfigProperties;
import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;


@ExtendWith(SpringExtension.class)
public class ListDataRepositoryTest {
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
        when(props.getImpl()).thenReturn(NAME);
    //    ReflectionTestUtils.setField(rep, "impl", NAME);
        DataDTO employ = rep.addEmployee(createEmployee());
        assertEquals(NAME, employ.getImpl());
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
