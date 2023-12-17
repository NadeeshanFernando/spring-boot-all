package com.anton.demo.dto.request;

import lombok.*;

/**
 * @author by nadeeshan_fdz
 */
@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class EmployeeRequestDto {
    public Long id;
    public String empName;
    public String empSalary;
    public String empEmail;
    public Long deptId;
}
