package com.anton.demo.controller;

import com.anton.demo.dto.Response;
import com.anton.demo.dto.request.DepartmentRequestDto;
import com.anton.demo.dto.response.DepartmentResponseDto;
import com.anton.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author by nadeeshan_fdz
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Response<DepartmentResponseDto>> saveDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){
        Response<DepartmentResponseDto> response = departmentService.saveDepartment(departmentRequestDto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<Response<List<DepartmentResponseDto>>> getAllDepartment(){
        Response<List<DepartmentResponseDto>> response = departmentService.getAllDepartment();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<DepartmentResponseDto>> getDepartmentById(@RequestParam Long id){
        Response<DepartmentResponseDto> response = departmentService.getDepartmentById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Response<DepartmentResponseDto>> updateDepartment(@RequestBody DepartmentRequestDto departmentRequestDto, @RequestParam Long id){
        Response<DepartmentResponseDto> response = departmentService.updateDepartment(departmentRequestDto, id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
