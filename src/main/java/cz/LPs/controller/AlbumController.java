package cz.LPs.controller;

import cz.LPs.dto.AlbumDto;
import cz.LPs.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @PostMapping({"/albums", "/albums/"})
    public AlbumDto addGrade(@RequestBody AlbumDto albumDto){
        return albumService.addAlbum(albumDto);
    }
    @GetMapping({"/albums", "/albums/"})
    public List<AlbumDto> getAll(){
        return albumService.getAllAlbums();
    }
    @GetMapping({"/albums/{albumId}", "/albums/{albumId}/"})
    public AlbumDto getGradeById(@PathVariable int albumId){
        return albumService.getAlbum(albumId);
    }
    @PutMapping({"/albums/{albumId}", "/albums/{albumId}/"})
    public AlbumDto editGrade(@PathVariable("albumId") int id, @RequestBody AlbumDto albumDto){
        return albumService.editGrade(id,albumDto);
    }
    @DeleteMapping({"/albums/{albumId}", "/albums/{albumId}/"})
    public  AlbumDto deleteAlbum(@PathVariable int albumId){
        return albumService.deleteAlbum(albumId);
    }
}
