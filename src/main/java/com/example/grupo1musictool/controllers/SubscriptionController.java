package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.MerchandisingDTO;
import com.example.grupo1musictool.dtos.SubscriptionDTO;
import com.example.grupo1musictool.entities.Suscription;
import com.example.grupo1musictool.serviceinterfaces.ISuscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suscripciones")
public class SubscriptionController {
    @Autowired
    private ISuscriptionService pS;
    @GetMapping
    public List<SubscriptionDTO> listar(){
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SubscriptionDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody SubscriptionDTO dto){
        ModelMapper m = new ModelMapper();
        Suscription d = m.map(dto, Suscription.class);
        pS.insert(d);
    }
    @PatchMapping
    public void actualizar(@RequestBody SubscriptionDTO dto){
        ModelMapper m = new ModelMapper();
        Suscription s = m.map(dto, Suscription.class);
        pS.update(s);
    }
    @GetMapping("/{id}")
    public SubscriptionDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        SubscriptionDTO dto = m.map(pS.listId(id), SubscriptionDTO.class);
        return dto;
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){pS.delete(id);}

    @GetMapping("/buscartipodesuscripcion")
    public List<SubscriptionDTO> buscartipodesuscripcion(@RequestParam String tiposuscripcion) {
        return pS.buscartipodesuscripcion(tiposuscripcion).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SubscriptionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarfecharango")
    public List<SubscriptionDTO> buscarrango(@RequestParam("fechainicio") LocalDate fi, @RequestParam("fechafin") LocalDate ff) {
        return pS.buscarrango(fi,ff).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SubscriptionDTO.class);
        }).collect(Collectors.toList());
    }
}
