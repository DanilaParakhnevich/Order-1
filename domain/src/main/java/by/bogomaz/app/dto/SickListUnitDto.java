package by.bogomaz.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SickListUnitDto {

    private long id;
    private EmployeeDto employee;
    private Instant startTime;
    private Instant endTime;

}
