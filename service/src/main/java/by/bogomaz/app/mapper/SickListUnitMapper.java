package by.bogomaz.app.mapper;

import by.bogomaz.app.dto.SickListUnitDto;
import by.bogomaz.app.entity.SickListUnit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SickListUnitMapper {

    SickListUnit toEntity(SickListUnitDto sickListUnit);

    SickListUnitDto toDto(SickListUnit sickListUnit);

}
