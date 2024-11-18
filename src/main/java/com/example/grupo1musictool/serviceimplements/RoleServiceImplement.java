package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Role;
import com.example.grupo1musictool.repositories.IRoleRepository;
import com.example.grupo1musictool.serviceinterfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public void insert(Role rol){rR.save(rol);};
    @Override
    public List<Role> list(){return rR.findAll();};
    @Override
    public void delete(Long idRol){rR.deleteById(idRol);};
    @Override
    public Role listarId(Long idRol){return rR.findById(idRol).orElse(new Role());};
}
