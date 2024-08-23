package cz.LPs.mapper;

import cz.LPs.dto.InterpretDto;
import cz.LPs.entity.InterpretEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InterpretMapper {
    InterpretEntity toEntity(InterpretDto interpretDto);
    InterpretDto toDto(InterpretEntity entity);
}
