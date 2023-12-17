package com.anton.demo.controller;

import com.anton.demo.dto.Response;
import com.anton.demo.dto.request.DepartmentRequestDto;
import com.anton.demo.dto.request.EmployeeRequestDto;
import com.anton.demo.dto.response.DepartmentResponseDto;
import com.anton.demo.dto.response.EmployeeResponseDto;
import com.anton.demo.service.DepartmentService;
import com.anton.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author by nadeeshan_fdz
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Response<EmployeeResponseDto>> saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        Response<EmployeeResponseDto> response = employeeService.saveEmployee(employeeRequestDto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<Response<List<EmployeeResponseDto>>> getAllEmployee(){
        Response<List<EmployeeResponseDto>> response = employeeService.getAllEmployee();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<EmployeeResponseDto>> getEmployeeById(@RequestParam Long id){
        Response<EmployeeResponseDto> response = employeeService.getEmployeeById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Response<EmployeeResponseDto>> updateEmployee(@RequestBody EmployeeRequestDto employeeRequestDto, @RequestParam Long id){
        Response<EmployeeResponseDto> response = employeeService.updateEmployee(employeeRequestDto, id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
