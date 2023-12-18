package com.anton.demo.dto.response;

import lombok.*;

import java.io.Serializable;
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
public class DepartmentResponseDto implements Serializable {
    public Long id;
    public String deptName;
}
