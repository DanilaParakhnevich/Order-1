package by.bogomaz.app;

import by.bogomaz.app.dto.SickListUnitDto;

import java.util.List;
import java.util.Optional;

public interface SickListUnitService {
    Optional<SickListUnitDto> findById(Long id);

    void delete(Long id);

    List<SickListUnitDto> findAll();

    void save(SickListUnitDto object);

    void update (SickListUnitDto object);
}
