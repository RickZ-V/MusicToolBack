package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.MerchandisingDTO;
import com.example.grupo1musictool.dtos.PublicsDTO;
import com.example.grupo1musictool.entities.Publics;
import com.example.grupo1musictool.serviceinterfaces.IPublicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publicaciones")
public class PublicsController {
    @Autowired
    private IPublicService iP;
    @GetMapping
    public List<PublicsDTO> listar(){
        return iP.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PublicsDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody PublicsDTO dto){
        ModelMapper m = new ModelMapper();
        Publics d = m.map(dto, Publics.class);
        iP.insert(d);
    }
    @PatchMapping
    public void actualizar(@RequestBody PublicsDTO dto){
        ModelMapper m = new ModelMapper();
        Publics s = m.map(dto, Publics.class);
        iP.update(s);
    }
    @GetMapping("/{id}")
    public PublicsDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PublicsDTO dto = m.map(iP.listid(id), PublicsDTO.class);
        return dto;
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){iP.delete(id);}


    @GetMapping("/buscarfecha")
    public List<PublicsDTO> buscarFecha(@RequestParam("fechapublicacion") LocalDate fechapublicacion){
        return iP.buscarfecha(fechapublicacion).stream().map(x ->{
            ModelMapper m = new ModelMapper();
            return m.map(x, PublicsDTO.class);
        }).collect(Collectors.toList());
    }

}
