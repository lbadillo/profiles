package com.lbd.test.api;

import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;
import com.lbd.test.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
@AllArgsConstructor
public class TestController {

    private IEmployeeService employService;


    @PostMapping
    public DataDTO createUser(@RequestBody EmployeeDTO employee) {
        return employService.createEmployee(employee);

    }

    @GetMapping(value = "/{id}")
    public DataDTO getEmployee(@PathVariable UUID id) {
        return employService.getEmployee(id);
    }

    @GetMapping
    public List<DataDTO> getEmployees() {
        return employService.getEmployees();
    }
}

