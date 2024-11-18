package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.SurveyDTO;
import com.example.grupo1musictool.entities.Survey;
import com.example.grupo1musictool.serviceinterfaces.ISurveyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/encuestas")
public class SurveyController {
    @Autowired
    private ISurveyService sS;

    @GetMapping
    public List<SurveyDTO> listar() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SurveyDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody SurveyDTO dto) {
        ModelMapper m = new ModelMapper();
        Survey s = m.map(dto, Survey.class);
        sS.insertSurvey(s);
    }
    @PatchMapping
    public void actualizar(@RequestBody SurveyDTO dto) {
        System.out.println(dto);
        ModelMapper m = new ModelMapper();
        Survey s = m.map(dto, Survey.class);
        sS.updateSurvey(s);
    }

    @GetMapping("/{id}")
    public SurveyDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        SurveyDTO dto = m.map(sS.listid(id), SurveyDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id) {
        sS.deleteSurvey(id);
    }

    @GetMapping("/buscar_titulo")
    public List<SurveyDTO> buscar(@RequestParam String tl) {
        return sS.buscarTitulo(tl).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SurveyDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarfecha")//busqueda por fecha exacta
    public List<SurveyDTO> buscarFecha(@RequestParam LocalDate f) {
        return sS.buscarFecha(f).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SurveyDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscarfecharango")//busqueda por rango de fecha
    public List<SurveyDTO> buscarFecharango(@RequestParam("fechainicio") LocalDate fi,@RequestParam("fechafin") LocalDate ff) {
        return sS.buscarFecharango(fi,ff).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SurveyDTO.class);
        }).collect(Collectors.toList());
    }


}
