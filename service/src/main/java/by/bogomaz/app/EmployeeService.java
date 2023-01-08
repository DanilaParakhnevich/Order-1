package by.bogomaz.app;

import by.bogomaz.app.dto.EmployeeDto;
import by.bogomaz.app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto findByFullName(String name);

    void delete(Long id);

    List<EmployeeDto> findAll();

    void save(EmployeeDto object);

    void update (EmployeeDto object);
}
