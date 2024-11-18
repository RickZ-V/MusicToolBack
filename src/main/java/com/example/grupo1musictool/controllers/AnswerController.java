package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.AnswerDTO;

import com.example.grupo1musictool.dtos.totalEncuestasDTO;
import com.example.grupo1musictool.dtos.totalAnswerDTO;
import com.example.grupo1musictool.entities.Answer;
import com.example.grupo1musictool.serviceinterfaces.IAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuestas")
public class AnswerController {
@Autowired
private IAnswerService aS;
    @GetMapping
    public List<AnswerDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AnswerDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody AnswerDTO dto) {
        ModelMapper m = new ModelMapper();
        Answer a = m.map(dto, Answer.class);
        aS.insert(a);
    }
    @PatchMapping
    public void actualizar(@RequestBody AnswerDTO dto) {
        ModelMapper m = new ModelMapper();
        Answer a = m.map(dto, Answer.class);
        aS.update(a);
    }

    @GetMapping("/{id}")
    public AnswerDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        AnswerDTO dto = m.map(aS.listId(id), AnswerDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id) {
        aS.delete(id);
    }

    @GetMapping("/totalencuestas")
    public List<totalEncuestasDTO> totalEncuentas(){
        List<String[]> lista = aS.totalEncuestasRespondidas();
        List<totalEncuestasDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            totalEncuestasDTO dto = new totalEncuestasDTO();
            dto.setSu(columna[0]);
            dto.setTotal(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/totalrespuestas")
    public List<totalAnswerDTO> totalRespuestas(){
        List<String[]> lista = aS.totalRespuestas();
        List<totalAnswerDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            totalAnswerDTO dto = new totalAnswerDTO();
            dto.setTotal(Integer.parseInt(columna[0]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
