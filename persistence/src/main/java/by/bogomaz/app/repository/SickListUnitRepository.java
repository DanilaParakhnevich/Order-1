package by.bogomaz.app.repository;

import by.bogomaz.app.entity.SickListUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SickListUnitRepository extends JpaRepository<SickListUnit,Long> {
}
