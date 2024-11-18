package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.MensajeDTO;
import com.example.grupo1musictool.entities.Mensaje;
import com.example.grupo1musictool.serviceinterfaces.IMensajeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {
    @Autowired
    private IMensajeService mS;

    @GetMapping
    public List<MensajeDTO> listar(){
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MensajeDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody MensajeDTO dto){
        ModelMapper m = new ModelMapper();
        Mensaje msg = m.map(dto, Mensaje.class);
        mS.insert(msg);
    }
    @GetMapping("/{id}")
    public MensajeDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        MensajeDTO dto = m.map(mS.listId(id), MensajeDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody MensajeDTO dto){
        ModelMapper m = new ModelMapper();
        Mensaje msg = m.map(dto, Mensaje.class);
        mS.update(msg);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        mS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<MensajeDTO> buscar(@RequestParam String contenido){
        return mS.buscar(contenido).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, MensajeDTO.class);
        }).collect(Collectors.toList());
    }
}
