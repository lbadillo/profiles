package com.lbd.test.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
public class DataDTO {
    private UUID id;
    @JsonProperty(value = "employee")
    private EmployeeDTO employeeDTO;
    private String  impl;

}
