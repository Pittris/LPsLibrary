package cz.LPs.mapper;

import cz.LPs.dto.AlbumDto;
import cz.LPs.entity.AlbumEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = InterpretMapper.class)
public interface AlbumMapper {
    AlbumEntity toEntity(AlbumDto albumDto);

    @Mapping(target = "interpretId", source = "interpret.id")
    AlbumDto toDto(AlbumEntity albumEntity);

    AlbumEntity updateEntity(AlbumDto albumDto, @MappingTarget AlbumEntity albumEntity);
}
