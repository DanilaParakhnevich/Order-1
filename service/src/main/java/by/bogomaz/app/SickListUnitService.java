package by.bogomaz.app;

import by.bogomaz.app.dto.SickListUnitDto;

import java.util.List;

public interface SickListUnitService {
    SickListUnitDto findById(Long id);

    void delete(Long id);

    List<SickListUnitDto> findAll();

    void save(SickListUnitDto object);

    void update (SickListUnitDto object);
}
