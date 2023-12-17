package com.anton.demo.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author by nadeeshan_fdz
 */
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_salary")
    private String empSalary;
    @Column(name = "emp_email")
    private String empEmail;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;
}
