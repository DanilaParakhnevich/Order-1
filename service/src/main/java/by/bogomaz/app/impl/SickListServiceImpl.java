package by.bogomaz.app.impl;

import by.bogomaz.app.dto.SickListUnitDto;
import by.bogomaz.app.entity.SickListUnit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.bogomaz.app.repository.SickListRepository;
import by.bogomaz.app.SickListService;
import by.bogomaz.app.mapper.SickListUnitMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SickListServiceImpl implements SickListService {

    private SickListRepository sickListRepository;
    private SickListUnitMapper sickListUnitMapper;


    @Override
    public Optional<SickListUnitDto> findById(Long id) {
        Optional<SickListUnit> sickListUnit = sickListRepository.findById(id);

        return sickListUnit.map(sickListUnitMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        sickListRepository.deleteById(id);
    }

    @Override
    public List<SickListUnitDto> findAll() {
        return sickListRepository.findAll().stream()
                .map(sickListUnitMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(SickListUnitDto sickListDto) {
        sickListRepository.save(sickListUnitMapper.toEntity(sickListDto));
    }

    @Override
    public void update(SickListUnitDto sickListDto) {
        SickListUnit sickListUnit = sickListUnitMapper.toEntity(sickListDto);

        sickListRepository.save(sickListUnit);
    }

    @Autowired
    public void setSickListRepository(SickListRepository sickListRepository) {
        this.sickListRepository = sickListRepository;
    }

    @Autowired
    public void setSickListUnitMapper(SickListUnitMapper sickListUnitMapper) {
        this.sickListUnitMapper = sickListUnitMapper;
    }
}
