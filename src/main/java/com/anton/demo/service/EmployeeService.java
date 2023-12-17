package com.anton.demo.service;

import com.anton.demo.dto.Response;
import com.anton.demo.dto.request.EmployeeRequestDto;
import com.anton.demo.dto.response.EmployeeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by nadeeshan_fdz
 */
public interface EmployeeService {
    Response<EmployeeResponseDto> saveEmployee(EmployeeRequestDto employeeRequestDto);

    Response<List<EmployeeResponseDto>> getAllEmployee();

    Response<EmployeeResponseDto> getEmployeeById(Long id);

    Response<EmployeeResponseDto> updateEmployee(EmployeeRequestDto employeeRequestDto, Long id);
}
