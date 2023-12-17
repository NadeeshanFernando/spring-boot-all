package com.anton.demo.service.impl;

import com.anton.demo.dto.Response;
import com.anton.demo.dto.request.EmployeeRequestDto;
import com.anton.demo.dto.response.EmployeeResponseDto;
import com.anton.demo.model.Department;
import com.anton.demo.model.Employee;
import com.anton.demo.repository.DepartmentRepo;
import com.anton.demo.repository.EmployeeRepo;
import com.anton.demo.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Response<EmployeeResponseDto> saveEmployee(EmployeeRequestDto employeeRequestDto) {
        Response<EmployeeResponseDto> response = new Response<>();

        Optional<Department> departmentOptional = departmentRepo.findById(employeeRequestDto.getDeptId());
        if(departmentOptional.isEmpty()){
            return ResponseUtil.handleNotFoundResponse(response, "Department not found");
        }

        boolean isEmployeeExist = employeeRepo.existsByDepartmentAndEmpNameIgnoreCase(departmentOptional.get(), employeeRequestDto.empName);
        if(isEmployeeExist){
            return ResponseUtil.handleConflictResponse(response, "Employee name already exist");
        }

        Employee employee = new Employee();
        employee.setEmpName(employeeRequestDto.getEmpName());
        employee.setEmpSalary(employeeRequestDto.getEmpSalary());
        employee.setEmpEmail(employeeRequestDto.getEmpEmail());
        employee.setDepartment(departmentOptional.get());

        employeeRepo.save(employee);
        EmployeeResponseDto employeeResponseDto = modelMapper.map(employee, EmployeeResponseDto.class);

        return ResponseUtil.handleCreatedResponse(response, employeeResponseDto, "Employee created successfully");
    }

    @Override
    public Response<List<EmployeeResponseDto>> getAllEmployee() {
        Response<List<EmployeeResponseDto>> response = new Response<>();

        List<Employee> employeeList = employeeRepo.findAll();
        if(employeeList.isEmpty()){
            return ResponseUtil.handleEmptyResponse(response, "Employees not exist");
        }
        else{
            List<EmployeeResponseDto> employeeResponseDto = employeeList.stream()
                    .map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                    .collect(Collectors.toList());
            return ResponseUtil.handleOkResponse(response, employeeResponseDto, "Employees retrieved successfully");
        }
    }

    @Override
    public Response<EmployeeResponseDto> getEmployeeById(Long id) {
        Response<EmployeeResponseDto> response = new Response<>();

        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if(employeeOptional.isEmpty()){
            return ResponseUtil.handleNotFoundResponse(response, "Employee not found");
        }
        else{
            EmployeeResponseDto employeeResponseDto = modelMapper.map(employeeOptional, EmployeeResponseDto.class);
            return ResponseUtil.handleOkResponse(response, employeeResponseDto, "Employee retrieved successfully");
        }
    }

    @Override
    public Response<EmployeeResponseDto> updateEmployee(EmployeeRequestDto employeeRequestDto, Long id) {
        Response<EmployeeResponseDto> response = new Response<>();

        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if(employeeOptional.isEmpty()){
            return ResponseUtil.handleNotFoundResponse(response, "Employee not found");
        }
        Optional<Department> departmentOptional = departmentRepo.findById(employeeRequestDto.getDeptId());
        if(departmentOptional.isEmpty()){
            return ResponseUtil.handleNotFoundResponse(response, "Department not found");
        }
        boolean isEmployeeExist = employeeRepo.existsByDepartmentAndEmpNameIgnoreCase(departmentOptional.get(), employeeRequestDto.empName);
        if(isEmployeeExist){
            return ResponseUtil.handleConflictResponse(response, "Employee name already exist");
        }
        else {
            if(employeeRepo.existsByDepartmentAndEmpNameIgnoreCaseAndEmpIdNot(departmentOptional.get(), employeeRequestDto.getEmpName(),id)){
                return ResponseUtil.handleConflictResponse(response, "Employee name already exist within the department");
            }
            Employee currentEmployee = employeeOptional.get();
            currentEmployee.setEmpName(employeeRequestDto.getEmpName());
            currentEmployee.setEmpSalary(employeeRequestDto.getEmpSalary());
            currentEmployee.setEmpEmail(employeeRequestDto.getEmpEmail());
            currentEmployee.setDepartment(departmentOptional.get());

            employeeRepo.save(currentEmployee);
            EmployeeResponseDto employeeResponseDto = modelMapper.map(currentEmployee, EmployeeResponseDto.class);

            return ResponseUtil.handleOkResponse(response, employeeResponseDto, "Employee updated successfully");
        }
    }
}
