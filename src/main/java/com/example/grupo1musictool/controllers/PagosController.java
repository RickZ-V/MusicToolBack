package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.PagosDTO;
import com.example.grupo1musictool.entities.Pagos;
import com.example.grupo1musictool.serviceinterfaces.IPagosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.grupo1musictool.dtos.totalMetodoPagoAnsDTO;
import com.example.grupo1musictool.dtos.totalTipoSubsAnswDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagosController {
    @Autowired
    private IPagosService pgS;

    @GetMapping
    public List<PagosDTO> listar(){
        return pgS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PagosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody PagosDTO dto){
        ModelMapper m = new ModelMapper();
        Pagos pa = m.map(dto, Pagos.class);
        pgS.insert(pa);
    }

    @GetMapping("/{id}")
    public PagosDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        PagosDTO dto = m.map(pgS.listId(id), PagosDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody PagosDTO dto){
        ModelMapper m = new ModelMapper();
        Pagos pa = m.map(dto,Pagos.class);
        pgS.update(pa);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        pgS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<PagosDTO> buscar(@RequestParam Double monto){
        return pgS.buscar(monto).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PagosDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/totalmetodopago")
    public List<totalMetodoPagoAnsDTO> totalPago(){
        List<String[]> lista = pgS.totalMetodoPago();
        List<totalMetodoPagoAnsDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            totalMetodoPagoAnsDTO dto = new totalMetodoPagoAnsDTO();
            dto.setMount(columna[0]);
            dto.setTotal(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/totaltiposubs")
    public List<totalTipoSubsAnswDTO> totalSubs(){
        List<String[]> lista = pgS.totalTipoSub();
        List<totalTipoSubsAnswDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            totalTipoSubsAnswDTO dto = new totalTipoSubsAnswDTO();
            dto.setSubs(columna[0]);
            dto.setTotalSubs(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }



}
