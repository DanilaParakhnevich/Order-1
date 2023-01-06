package service.impl;

import dto.SickListDto;
import entity.SickList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import persistance.SickListRepository;
import service.SickListService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SickListServiceImpl implements SickListService {

    private final SickListRepository sickListRepository;
    private final UserServiceImpl userService;

    @Override
    public Optional<SickList> findById(Long id) {
        return sickListRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        sickListRepository.deleteById(id);
    }

    @Override
    public List<SickList> findAll() {
        return sickListRepository.findAll();
    }

    @Override
    public void save(SickListDto sickListDto) {
        SickList sickList = new SickList();
        sickListRepository.save(setSickList(sickList,sickListDto));
    }

    @Override
    public void update(SickListDto sickListDto, Long id) {
        sickListRepository.findById(id).map(newSickList -> sickListRepository
                .save(setSickList(newSickList,sickListDto )));
    }

    private SickList setSickList(SickList sickList, SickListDto sickListDto){
        sickList.setName(userService.findByName(sickListDto.getName()));
        sickList.setStartTime(sickListDto.getStartTime());
        sickList.setEndTime(sickListDto.getEndTime());

        return sickList;
    }
}
