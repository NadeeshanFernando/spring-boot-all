package com.anton.demo.dto.response;

import lombok.*;

/**
 * @author by nadeeshan_fdz
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeResponseDto {
    public Long id;
    public String empName;
    public String empSalary;
    public String empEmail;
    public DepartmentResponseDto department;
}
