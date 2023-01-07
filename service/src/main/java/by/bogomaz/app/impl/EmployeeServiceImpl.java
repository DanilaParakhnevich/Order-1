package by.bogomaz.app.impl;

import by.bogomaz.app.dto.EmployeeDto;
import by.bogomaz.app.mapper.EmployeeMapper;
import by.bogomaz.app.repository.EmployeeRepository;
import by.bogomaz.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.bogomaz.app.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

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
    public void save(EmployeeDto userDto) {
        Employee user = new Employee();
        employeeRepository.save(setUser(user,userDto));
    }

    @Override
    public void update(EmployeeDto userDto, Long id) {
        employeeRepository.findById(id).map(newUser -> employeeRepository
                .save(setUser(newUser,userDto )));
    }

    private Employee setUser(Employee user, EmployeeDto userDto){
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
