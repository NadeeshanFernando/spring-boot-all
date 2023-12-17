package com.anton.demo.service;

import com.anton.demo.dto.Response;
import com.anton.demo.dto.request.DepartmentRequestDto;
import com.anton.demo.dto.response.DepartmentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by nadeeshan_fdz
 */
public interface DepartmentService {
    Response<DepartmentResponseDto> saveDepartment(DepartmentRequestDto departmentRequestDto);

    Response<List<DepartmentResponseDto>> getAllDepartment();

    Response<DepartmentResponseDto> getDepartmentById(Long id);

    Response<DepartmentResponseDto> updateDepartment(DepartmentRequestDto departmentRequestDto, Long id);
}
