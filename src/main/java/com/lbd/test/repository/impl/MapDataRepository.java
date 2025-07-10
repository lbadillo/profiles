package com.lbd.test.repository.impl;

import com.lbd.test.domain.DataDTO;
import com.lbd.test.domain.EmployeeDTO;
import com.lbd.test.repository.IDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Component

@RequiredArgsConstructor
@Profile("map")

public class MapDataRepository implements IDataRepository {

    private final Map<UUID, EmployeeDTO> employeeRep;
    @Value("${spring.profiles.active}")
    private String impl;

    @Override
    public DataDTO addEmployee(EmployeeDTO employ) {

        UUID id = UUID.randomUUID();
        employeeRep.put(id, employ);
        return DataDTO.builder()
                .id(id)
                .employeeDTO(employ)
                .impl(impl)
                .build();

    }

    @Override
    public DataDTO getEmployee(UUID id) {
        return DataDTO.builder()
                .id(id)
                .employeeDTO(employeeRep.get(id))
                .build();

    }

    @Override
    public List<DataDTO> getEmployees() {
        return employeeRep.entrySet().stream().map(e ->
                DataDTO
                        .builder()
                        .id(e.getKey())
                        .employeeDTO(e.getValue())
                        .build()
        ).toList();

    }


}
