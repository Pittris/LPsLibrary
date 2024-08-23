package cz.LPs.service;

import cz.LPs.dto.TrackDto;
import cz.LPs.entity.AlbumEntity;
import cz.LPs.entity.TrackEntity;
import cz.LPs.mapper.TrackMapper;
import cz.LPs.repository.AlbumRepository;
import cz.LPs.repository.InterpretRepository;
import cz.LPs.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {
    @Autowired
    TrackRepository trackRepository;
    @Autowired
    TrackMapper trackMapper;
    @Autowired
    InterpretRepository interpretRepository;
    @Autowired
    AlbumRepository albumRepository;

    public TrackDto addTrack(TrackDto trackDto){
        TrackEntity trackToAdd =trackMapper.toEntity(trackDto);
        trackToAdd.setInterpret(interpretRepository.getReferenceById(trackDto.getInterpretId()));
        trackToAdd.setAlbum(albumRepository.getReferenceById(trackDto.getAlbumId()));
        return trackMapper.toDto(trackRepository.save(trackToAdd));
    }
    public List<TrackDto> getAllTracks(){
        List<TrackDto> allTracks = new ArrayList<>();
        for (TrackEntity trackEntity : trackRepository.findAll()){
            allTracks.add(trackMapper.toDto(trackEntity));

        }
        return allTracks;
    }
    public List<TrackDto> getAllAlbumTracks(AlbumEntity albumId, TrackDto trackDto){
        List<TrackDto> allAlbumTracks = new ArrayList<>();
        for (TrackEntity albumEntity : trackRepository.findAll()){
            allAlbumTracks.add(trackMapper.toDto(trackRepository.getReferenceById(albumEntity.getId())));

        }
        return allAlbumTracks;
    }
    public TrackDto getTrack(int trackId){
        return trackMapper.toDto(trackRepository.getReferenceById(trackId));
    }
    public TrackDto editTrack(int trackId, TrackDto trackDto){
        trackDto.setId(trackId);
        TrackEntity trackEntity = trackRepository.getReferenceById(trackId);
        trackMapper.updateEntity(trackDto, trackEntity);
        trackEntity.setAlbum(albumRepository.getReferenceById(trackDto.getAlbumId()));
        trackEntity.setInterpret(interpretRepository.getReferenceById(trackDto.getInterpretId()));
        return trackMapper.toDto(trackRepository.save(trackEntity));
    }
    public TrackDto deleteTrack(int trackId){
        TrackEntity trackEntity = trackRepository.getReferenceById(trackId);
        TrackDto deletedTrack = trackMapper.toDto(trackEntity);
        trackRepository.delete(trackEntity);
        return deletedTrack;
    }
}
