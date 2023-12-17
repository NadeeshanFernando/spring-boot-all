package com.anton.demo.service.impl;

import com.anton.demo.dto.Response;
import com.anton.demo.dto.request.DepartmentRequestDto;
import com.anton.demo.dto.response.DepartmentResponseDto;
import com.anton.demo.model.Department;
import com.anton.demo.repository.DepartmentRepo;
import com.anton.demo.service.DepartmentService;
import com.anton.demo.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author by nadeeshan_fdz
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Response<DepartmentResponseDto> saveDepartment(DepartmentRequestDto departmentRequestDto) {
        Response<DepartmentResponseDto> response = new Response<>();

        Optional<Department> departmentOptional = departmentRepo.findByDeptName(departmentRequestDto.deptName);
        if(departmentOptional.isPresent()){
            return ResponseUtil.handleConflictResponse(response, "Department already exist");
        }
        else{
            Department department = new Department();
            department.setDeptName(departmentRequestDto.deptName);

            departmentRepo.save(department);
            DepartmentResponseDto departmentResponseDto = modelMapper.map(department, DepartmentResponseDto.class);
            return ResponseUtil.handleCreatedResponse(response, departmentResponseDto, "Department created successfully");
        }
    }

    @Override
    public Response<List<DepartmentResponseDto>> getAllDepartment() {
        Response<List<DepartmentResponseDto>> response = new Response<>();

        List<Department> departmentList = departmentRepo.findAll();
        if(departmentList.isEmpty()){
            return ResponseUtil.handleEmptyResponse(response, "Departments not exist");
        }
        else{
            List<DepartmentResponseDto> departmentResponseDtoList = departmentList.stream()
                    .map(department -> modelMapper.map(department, DepartmentResponseDto.class))
                    .collect(Collectors.toList());
            return ResponseUtil.handleOkResponse(response, departmentResponseDtoList, "Departments retrieved successfully");
        }
    }

    @Override
    public Response<DepartmentResponseDto> getDepartmentById(Long id) {
        Response<DepartmentResponseDto> response = new Response<>();

        Optional<Department> departmentOptional = departmentRepo.findById(id);
        if(departmentOptional.isEmpty()){
            return ResponseUtil.handleNotFoundResponse(response, "Department not found");
        }
        else{
            DepartmentResponseDto departmentResponseDto = modelMapper.map(departmentOptional, DepartmentResponseDto.class);
            return ResponseUtil.handleOkResponse(response, departmentResponseDto, "Department retrieved successfully");
        }
    }

    @Override
    public Response<DepartmentResponseDto> updateDepartment(DepartmentRequestDto departmentRequestDto, Long id) {
        Response<DepartmentResponseDto> response = new Response<>();

        Optional<Department> departmentOptional = departmentRepo.findById(id);
        if(departmentOptional.isEmpty()){
            return ResponseUtil.handleNotFoundResponse(response, "Department not found");
        }
        if(departmentRepo.existsByDeptNameAndDeptIdNot(departmentRequestDto.deptName, id)){
            return ResponseUtil.handleConflictResponse(response, "Department name already exist");
        }
        Department currentDepartment = departmentOptional.get();
        currentDepartment.setDeptName(departmentRequestDto.deptName);
        departmentRepo.save(currentDepartment);

        DepartmentResponseDto departmentResponseDto = modelMapper.map(departmentOptional, DepartmentResponseDto.class);
        return ResponseUtil.handleOkResponse(response, departmentResponseDto, "Department updated successfully");
    }
}
