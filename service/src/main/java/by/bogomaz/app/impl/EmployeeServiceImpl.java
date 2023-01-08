package by.bogomaz.app.impl;

import by.bogomaz.app.dto.EmployeeDto;
import by.bogomaz.app.mapper.EmployeeMapper;
import by.bogomaz.app.repository.EmployeeRepository;
import by.bogomaz.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.bogomaz.app.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto findById(long id) {
        return employeeMapper.toDto(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeDto findByFullName(String fullName) {
        return employeeMapper.toDto(employeeRepository.findByFullName(fullName));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> employeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public void save(EmployeeDto employee) {
        employeeRepository.save(employeeMapper.toEntity(employee));
    }

    @Override
    public void update(EmployeeDto employeeDto) {
        employeeRepository.findById(employeeDto.getId()).map(
                employee ->  employeeRepository.save(employeeMapper.toEntity(employeeDto)));
    }

    private Employee setEmployee(Employee user, EmployeeDto userDto){
        user.setFullName(userDto.getFullName());
        user.setPosition(userDto.getPosition());

        return user;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

}
