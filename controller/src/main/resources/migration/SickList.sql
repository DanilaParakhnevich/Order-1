drop table SickListUnit;

create table SickListUnit (
        id bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        employeeId bigint NOT NULL REFERENCES Employees(id),
        startTime datetime NOT NULL,
        endTime datetime NOT NULL
);