package com.lbd.test.service.impl;

import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;

import com.lbd.test.repository.IDataRepository;
import com.lbd.test.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService {

    private final IDataRepository rep;

    public EmployeeService(IDataRepository repTmp) {
        rep = repTmp;
    }


    @Override
    public DataDTO createEmployee(EmployeeDTO employee) {
        return rep.addEmployee(employee);
    }

    @Override
    public DataDTO getEmployee(UUID id) {
        return rep.getEmployee(id);
    }

    @Override
    public List<DataDTO> getEmployees() {
        return rep.getEmployees();
    }

}
