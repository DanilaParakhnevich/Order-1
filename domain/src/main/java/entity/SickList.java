package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SickList {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "name", referencedColumnName = "name")
    private User name;
    private Instant startTime;
    private Instant endTime;
}
