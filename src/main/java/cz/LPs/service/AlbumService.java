package cz.LPs.service;

import cz.LPs.dto.AlbumDto;
import cz.LPs.entity.AlbumEntity;
import cz.LPs.mapper.AlbumMapper;
import cz.LPs.repository.AlbumRepository;
import cz.LPs.repository.InterpretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    InterpretRepository interpretRepository;
    public AlbumDto addAlbum(AlbumDto albumDto){
        AlbumEntity gradeToAdd =albumMapper.toEntity(albumDto);
        gradeToAdd.setInterpret(interpretRepository.getReferenceById(albumDto.getInterpretId()));
        return albumMapper.toDto(albumRepository.save(gradeToAdd));
    }
    public List<AlbumDto> getAllAlbums(){
        List<AlbumDto> allGrades = new ArrayList<>();
        for (AlbumEntity albumEntity : albumRepository.findAll()){
            allGrades.add(albumMapper.toDto(albumEntity));

        }
        return allGrades;
    }
    public AlbumDto getAlbum(int albumId){
        return albumMapper.toDto(albumRepository.getReferenceById(albumId));
    }
    public AlbumDto editGrade(int albumId, AlbumDto albumDto){
        albumDto.setId(albumId);
        AlbumEntity albumEntity = albumRepository.getReferenceById(albumId);
        albumMapper.updateEntity(albumDto, albumEntity);
        albumEntity.setInterpret(interpretRepository.getReferenceById(albumDto.getInterpretId()));
        return albumMapper.toDto(albumRepository.save(albumEntity));
    }
    public AlbumDto deleteAlbum(int albumId){
        AlbumEntity albumEntity = albumRepository.getReferenceById(albumId);
        AlbumDto deletedAlbum = albumMapper.toDto(albumEntity);
        albumRepository.delete(albumEntity);
        return deletedAlbum;
    }
}
