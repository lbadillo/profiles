package com.lbd.test.repository;

import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;

import java.util.List;
import java.util.UUID;

public interface IDataRepository {
    DataDTO addEmployee(EmployeeDTO employ);

    DataDTO getEmployee(UUID id);

    List<DataDTO> getEmployees();
}
