package cz.LPs.controller;

import cz.LPs.dto.AlbumDto;
import cz.LPs.dto.InterpretDto;
import cz.LPs.service.InterpretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InterpretController {
    @Autowired
    private InterpretService interpretService;
    @GetMapping({"/interprets", "/interprets/"})
    public List<InterpretDto> getInterprets(){
        return interpretService.getInterprets();
    }
    @GetMapping({"/interprets/{id}", "/interprets/{id}/"})
    public InterpretDto getInterprets(@PathVariable("id") Integer id){
        return interpretService.getInterpret(id);
    }
    @PostMapping({"/interprets", "/interprets/"})
    public InterpretDto addInterpret(@RequestBody InterpretDto interpretDto){
        return interpretService.addInterpret(interpretDto);
    }
    @PutMapping({"/interprets/{id}", "/interprets/{id}/"})
    public InterpretDto editInterpret(@PathVariable Integer id, @RequestBody InterpretDto interpretDto){
        return  interpretService.editInterpret(id, interpretDto);
    }
    @DeleteMapping({"/interprets/{id}", "/interprets/{id}/"})
    public InterpretDto deleteInterpret(@PathVariable Integer id){
        return interpretService.deleteInterpret(id);
    }
}
