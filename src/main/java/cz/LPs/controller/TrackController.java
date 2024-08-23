package cz.LPs.controller;

import cz.LPs.dto.TrackDto;
import cz.LPs.entity.AlbumEntity;
import cz.LPs.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrackController {
    @Autowired
    TrackService trackService;

    @PostMapping({"/tracks", "/tracks/"})
    public TrackDto addTrack(@RequestBody TrackDto trackDto){
        return trackService.addTrack(trackDto);
    }
    @GetMapping({"/tracks", "/tracks/"})
    public List<TrackDto> getAll(){
        return trackService.getAllTracks();
    }
    @GetMapping({"/tracks/{trackId}", "/tracks/{trackId}/"})
    public TrackDto getTrackById(@PathVariable int trackId){
        return trackService.getTrack(trackId);
    }
    @GetMapping({"/tracks/{albumId}", "/tracks/{albumId}/"})
    public List<TrackDto> getAllTrack(@PathVariable("albumId") AlbumEntity albumId, @RequestBody TrackDto trackDto){
        return trackService.getAllAlbumTracks(albumId, trackDto);
    }
    @PutMapping({"/tracks/{trackId}", "/tracks/{trackId}/"})
    public TrackDto editTrack(@PathVariable("trackId") int id, @RequestBody TrackDto trackDto){
        return trackService.editTrack(id,trackDto);
    }
    @DeleteMapping({"/tracks/{trackId}", "/tracks/{trackId}/"})
    public  TrackDto deleteTrack(@PathVariable int trackId){
        return trackService.deleteTrack(trackId);
    }
}
