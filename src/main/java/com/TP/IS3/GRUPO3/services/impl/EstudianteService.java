package com.TP.IS3.GRUPO3.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Perfil;
import com.TP.IS3.GRUPO3.domain.Estudiante;
import com.TP.IS3.GRUPO3.repositorys.IEstudianteRepository;
import com.TP.IS3.GRUPO3.services.IEstudianteService;
import com.TP.IS3.GRUPO3.util.EstudianteModel;

@Service
public class EstudianteService implements IEstudianteService, UserDetailsService {

    @Autowired
    private IEstudianteRepository usuarioRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Estudiante> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public EstudianteModel findById(int id) {
        return modelMapper.map(usuarioRepository.findByIdUsuario(id), EstudianteModel.class);
    }

    @Override
    public EstudianteModel findByNombreUsuario(String nombreUsuario) {
        return modelMapper.map(usuarioRepository.findByNombreUsuario(nombreUsuario), EstudianteModel.class);
    }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public EstudianteModel insertOrUpdate(EstudianteModel usuarioModel) {
        String clave = bCryptPasswordEncoder.encode(usuarioModel.getClave());
        usuarioModel.setClave(clave);
        Estudiante usuario = modelMapper.map(usuarioModel, Estudiante.class);
        usuario.setHabilitado(true);
        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, EstudianteModel.class);
    }

    @Override
    public boolean remove(int id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Estudiante> findByIdPerfil(int idPerfil) {
        List<Estudiante> lista = usuarioRepository.findByIdPerfil(idPerfil);
        return lista;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Estudiante usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        User u = buildUser(usuario, buildGrantedAuthorities(usuario.getPerfil()));
        return u;
    }

    private User buildUser(Estudiante usuario, List<GrantedAuthority> grantedAuthorities) {
        return new User(usuario.getNombreUsuario(), usuario.getClave(), usuario.isHabilitado(),
                true, true, true,
                grantedAuthorities);
    }

    private List<GrantedAuthority> buildGrantedAuthorities(Perfil perfil) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getNombre()));

        return new ArrayList<GrantedAuthority>(grantedAuthorities);
    }
}