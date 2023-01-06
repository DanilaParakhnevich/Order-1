package service;

import dto.SickListDto;
import entity.SickList;

import java.util.List;
import java.util.Optional;

public interface SickListService {
    Optional<SickList> findById(Long id);

    void delete(Long id);

    List<SickList> findAll();

    void save(SickListDto object);

    void update (SickListDto object, Long id);
}
