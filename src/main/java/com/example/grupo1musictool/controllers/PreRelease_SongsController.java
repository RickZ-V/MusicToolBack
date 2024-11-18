package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.ContarSongsDTO;
import com.example.grupo1musictool.dtos.totalSongsDTO;
import com.example.grupo1musictool.dtos.PreRelease_SongsDTO;
import com.example.grupo1musictool.dtos.totalAnswerDTO;
import com.example.grupo1musictool.entities.PreRelease_Songs;
import com.example.grupo1musictool.serviceinterfaces.IPreRelease_SongsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/precanciones")
public class PreRelease_SongsController {
    @Autowired
    private IPreRelease_SongsService pS;
    @GetMapping
    public List<PreRelease_SongsDTO> listar(){
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PreRelease_SongsDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody PreRelease_SongsDTO dto){
        ModelMapper m = new ModelMapper();
        PreRelease_Songs s = m.map(dto, PreRelease_Songs.class);
        pS.insertPreRelease(s);
    }
    @PatchMapping
    public void actualizar(@RequestBody PreRelease_SongsDTO dto){
        ModelMapper m = new ModelMapper();
        PreRelease_Songs s = m.map(dto, PreRelease_Songs.class);
        pS.updatetPreRelease(s);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){pS.deletePreRelease(id);}
    @GetMapping("/buscargenero")
    public List<PreRelease_SongsDTO> buscarGenero(@RequestParam String genre) {
        return pS.buscarGenero(genre).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,PreRelease_SongsDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarnombre")
    public List<PreRelease_SongsDTO> buscarNombre(@RequestParam String name) {
        return pS.buscarNombre(name).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,PreRelease_SongsDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public PreRelease_SongsDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PreRelease_SongsDTO dto = m.map(pS.listId(id), PreRelease_SongsDTO.class);
        return dto;
    }
    @GetMapping("/totalcancionesgenero")
    public List<ContarSongsDTO> cantidadCanciones() {
        List<String[]> lista = pS.contarCancionesOrden();
        List<ContarSongsDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ContarSongsDTO dto = new ContarSongsDTO();
            dto.setGenre(columna[0]);
            dto.setTotalSongs(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/totalcanciones")
    public List<totalSongsDTO> totalCanciones(){
        List<String[]> lista = pS.totalCanciones();
        List<totalSongsDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            totalSongsDTO dto = new totalSongsDTO();
            dto.setTotal(Integer.parseInt(columna[0]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
