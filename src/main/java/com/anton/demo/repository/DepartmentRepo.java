package com.anton.demo.repository;

import com.anton.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author by nadeeshan_fdz
 */
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Optional<Department> findByDeptName(String deptName);

    boolean existsByDeptNameAndDeptIdNot(String deptName, Long id);
}
