package by.bogomaz.app.repository;

import by.bogomaz.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFullName(String fullName);
}
