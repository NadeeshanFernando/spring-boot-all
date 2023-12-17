package com.anton.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * @author by nadeeshan_fdz
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private Long deptId;
    @Column(name = "dept_name")
    private String deptName;
    @OneToMany(mappedBy = "department")
    @JsonIgnoreProperties("employee")
    private Set<Employee> employeeSet;
}
