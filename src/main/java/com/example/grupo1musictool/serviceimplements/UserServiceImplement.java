package com.example.grupo1musictool.serviceimplements;

import com.example.grupo1musictool.entities.Users;
import com.example.grupo1musictool.repositories.IUserRepository;
import com.example.grupo1musictool.serviceinterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uS;
    @Override
    public void insert(Users usuario){uS.save(usuario);};
    @Override
    public List<Users> list(){return uS.findAll();};
    @Override
    public void delete(Long idUsuario){uS.deleteById(idUsuario);};
    @Override
    public Users listarId(Long idUsuario){return uS.findById(idUsuario).orElse(new Users());};
}
