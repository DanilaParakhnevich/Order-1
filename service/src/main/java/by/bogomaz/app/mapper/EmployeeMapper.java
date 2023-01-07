package by.bogomaz.app.mapper;

import by.bogomaz.app.dto.EmployeeDto;
import by.bogomaz.app.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeDto user);

    EmployeeDto toDto(Employee user);

}
