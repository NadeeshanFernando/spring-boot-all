package com.anton.demo.dto.request;

import lombok.*;

import java.util.Set;

/**
 * @author by nadeeshan_fdz
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentRequestDto {
    public Long id;
    public String deptName;
}
