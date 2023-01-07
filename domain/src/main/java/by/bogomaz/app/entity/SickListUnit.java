package by.bogomaz.app.entity;

import lombok.*;

import javax.persistence.*;

import java.time.Instant;

@Entity
@Data
@Table(name = "SickListUnit")
public class SickListUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @Column
    private Instant startTime;
    @Column
    private Instant endTime;

}
