package cz.LPs.service;

import cz.LPs.dto.InterpretDto;
import cz.LPs.entity.InterpretEntity;
import cz.LPs.mapper.InterpretMapper;
import cz.LPs.repository.InterpretRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterpretService {
    @Autowired
    private InterpretRepository interpretRepository;
    @Autowired
    private InterpretMapper interpretMapper;
    public List<InterpretDto> getInterprets(){
        List<InterpretEntity> interpretEntities = interpretRepository.findAll();
        List<InterpretDto> interpretDtos = new ArrayList<>();
        for(InterpretEntity interpretEntity : interpretEntities){
            interpretDtos.add(interpretMapper.toDto(interpretEntity));
        }
        return interpretDtos;
    }
    public InterpretDto addInterpret(InterpretDto interpretDto){
        InterpretEntity interpretEntity = interpretMapper.toEntity(interpretDto);
        InterpretEntity savedEntity = interpretRepository.save(interpretEntity);
        return interpretMapper.toDto(savedEntity);
    }
    public InterpretDto getInterpret(Integer id){
        InterpretEntity studentEntity = interpretRepository
                .findById(id).orElseThrow(EntityNotFoundException::new);
        return interpretMapper.toDto(studentEntity);
    }
    public InterpretDto editInterpret(Integer id, InterpretDto interpretDto){
        if(!interpretRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        InterpretEntity interpretEntity = interpretMapper.toEntity(interpretDto);
        interpretEntity.setId(id);
        InterpretEntity savedInterpret = interpretRepository.save(interpretEntity);
        return interpretMapper.toDto(savedInterpret);
    }
    public InterpretDto deleteInterpret(Integer id){
        InterpretEntity interpretToDelete = interpretRepository
                .findById(id).orElseThrow(EntityNotFoundException::new);
        InterpretDto deletedInterpret = interpretMapper.toDto(interpretToDelete);
        interpretRepository.delete(interpretToDelete);
        return deletedInterpret;
    }
}
