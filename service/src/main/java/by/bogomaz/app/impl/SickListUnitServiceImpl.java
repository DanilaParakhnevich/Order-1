package by.bogomaz.app.impl;

import by.bogomaz.app.dto.SickListUnitDto;
import by.bogomaz.app.entity.SickListUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.bogomaz.app.repository.SickListUnitRepository;
import by.bogomaz.app.SickListUnitService;
import by.bogomaz.app.mapper.SickListUnitMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SickListUnitServiceImpl implements SickListUnitService {

    private SickListUnitRepository sickListRepository;
    private SickListUnitMapper sickListUnitMapper;


    @Override
    public SickListUnitDto findById(Long id) {
        return sickListUnitMapper.toDto(sickListRepository.findById(id).get());
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
    public void setSickListRepository(SickListUnitRepository sickListRepository) {
        this.sickListRepository = sickListRepository;
    }

    @Autowired
    public void setSickListUnitMapper(SickListUnitMapper sickListUnitMapper) {
        this.sickListUnitMapper = sickListUnitMapper;
    }
}
