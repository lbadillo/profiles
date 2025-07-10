package com.lbd.test.service;

import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;

import java.util.List;
import java.util.UUID;

public interface IEmployeeService {
    DataDTO createEmployee(EmployeeDTO employee);

    DataDTO getEmployee(UUID id);

    List<DataDTO> getEmployees();
}
