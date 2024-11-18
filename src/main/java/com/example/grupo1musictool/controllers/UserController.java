package com.example.grupo1musictool.controllers;

import com.example.grupo1musictool.dtos.UserDTO;
import com.example.grupo1musictool.dtos.UserListDTO;
import com.example.grupo1musictool.entities.Users;
import com.example.grupo1musictool.serviceinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping
    public void registrar(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @PutMapping
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.insert(u);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listarId(id), UserDTO.class);
        return dto;
    }

    @GetMapping
    public List<UserListDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserListDTO.class);
        }).collect(Collectors.toList());
    }
}
