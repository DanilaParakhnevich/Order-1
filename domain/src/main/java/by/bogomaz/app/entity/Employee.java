package by.bogomaz.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fullName;
    @Column
    private String position;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<SickListUnit> sickListUnits;

}
