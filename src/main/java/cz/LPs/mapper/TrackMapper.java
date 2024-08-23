package cz.LPs.mapper;

import cz.LPs.dto.TrackDto;
import cz.LPs.entity.TrackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {InterpretMapper.class, AlbumMapper.class})
public interface TrackMapper {
    TrackEntity toEntity(TrackDto trackDto);
    @Mapping(target = "interpretId", source = "interpret.id")
    @Mapping(target = "albumId", source = "album.id")
    TrackDto toDto(TrackEntity trackEntity);

    TrackEntity updateEntity (TrackDto trackDto, @MappingTarget TrackEntity trackEntity);
}
