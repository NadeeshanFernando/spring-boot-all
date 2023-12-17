package com.anton.demo.repository;

import com.anton.demo.model.Department;
import com.anton.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author by nadeeshan_fdz
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmpName(String empName);

    boolean existsByDepartmentAndEmpNameIgnoreCase(Department department, String empName);

    boolean existsByDepartmentAndEmpNameIgnoreCaseAndEmpIdNot(Department department, String empName, Long id);
}
