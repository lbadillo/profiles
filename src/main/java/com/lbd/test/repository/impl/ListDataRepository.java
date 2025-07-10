package com.lbd.test.repository.impl;

import com.lbd.test.config.ConfigProperties;
import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;
import com.lbd.test.repository.IDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
@Profile("list")
public class ListDataRepository implements IDataRepository {

    private final List<DataDTO> employeeRep;
    private final ConfigProperties props;



    @Override
    public DataDTO addEmployee(EmployeeDTO employ) {
        UUID id = UUID.randomUUID();
        DataDTO tmp = DataDTO.builder()
                .id(id)
                .employeeDTO(employ)
                .impl(props.getImpl())
                .build();
        employeeRep.add(tmp);
        return tmp;

    }

    @Override
    public DataDTO getEmployee(UUID id) {
        return employeeRep.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(DataDTO.builder().id(id).build());

    }

    @Override
    public List<DataDTO> getEmployees() {
        return employeeRep.stream().toList();

    }


}
