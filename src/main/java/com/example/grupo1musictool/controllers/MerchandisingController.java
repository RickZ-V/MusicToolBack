package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.MerchandisingDTO;
import com.example.grupo1musictool.entities.Merchandising;
import com.example.grupo1musictool.serviceinterfaces.IMerchandisingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Merchandising")

public class MerchandisingController {

    @Autowired
    private IMerchandisingService mS;

    @GetMapping
    public List<MerchandisingDTO> list() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MerchandisingDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertMerchandising(@RequestBody MerchandisingDTO dto) {
        ModelMapper m = new ModelMapper();
        Merchandising i = m.map(dto, Merchandising.class);
        mS.insertMerchandising(i);
    }


    @PatchMapping
    public void updateMerchandising(@RequestBody MerchandisingDTO dto) {
        ModelMapper m = new ModelMapper();
        Merchandising me = m.map(dto, Merchandising.class);
        mS.updateMerchandising(me);
    }

    @GetMapping("/{id}")
    public MerchandisingDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MerchandisingDTO dto = m.map(mS.listId(id), MerchandisingDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteMerchandising(@PathVariable("id") int id) {
        mS.deleteMerchandising(id);
    }

    @GetMapping("/buscarnombre")
    public List<MerchandisingDTO> buscarNombre(@RequestParam String name) {
        return mS.buscarnombre(name).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MerchandisingDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscardescripcion")
    public List<MerchandisingDTO> buscarDescripcion(@RequestParam String name) {
        return mS.buscarnombre(name).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MerchandisingDTO.class);
        }).collect(Collectors.toList());
    }

}
