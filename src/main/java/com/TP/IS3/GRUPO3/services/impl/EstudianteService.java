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
import com.TP.IS3.GRUPO3.domain.model.EstudianteModel;
import com.TP.IS3.GRUPO3.domain.Estudiante;
import com.TP.IS3.GRUPO3.domain.Materia;
import com.TP.IS3.GRUPO3.repositorys.IEstudianteRepository;
import com.TP.IS3.GRUPO3.repositorys.IMateriaRepository;
import com.TP.IS3.GRUPO3.services.IEstudianteService;

@Service
public class EstudianteService implements IEstudianteService, UserDetailsService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Autowired
    private IMateriaRepository materiaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public EstudianteModel findById(int id) {
        return modelMapper.map(estudianteRepository.findByIdUsuario(id), EstudianteModel.class);
    }

    @Override
    public EstudianteModel findByNombreUsuario(String nombreUsuario) {
        return modelMapper.map(estudianteRepository.findByNombreUsuario(nombreUsuario), EstudianteModel.class);
    }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public EstudianteModel insertOrUpdate(EstudianteModel estudianteModel) {
        String clave = bCryptPasswordEncoder.encode(estudianteModel.getClave());
        estudianteModel.setClave(clave);
        Estudiante usuario = modelMapper.map(estudianteModel, Estudiante.class);
        usuario.setHabilitado(true);
        estudianteRepository.save(usuario);
        return modelMapper.map(usuario, EstudianteModel.class);
    }

    @Override
    public boolean remove(int id) {
        try {
            estudianteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Estudiante> findByIdPerfil(int idPerfil) {
        List<Estudiante> lista = estudianteRepository.findByIdPerfil(idPerfil);
        return lista;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Estudiante usuario = estudianteRepository.findByNombreUsuario(nombreUsuario);
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

    @Override
    public void inscripcion(int idUsuario, int idMateria) {
        Estudiante estudiante = estudianteRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Materia materia = materiaRepository.findById(idMateria)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
    
        estudiante.getMaterias().add(materia);
        materia.getEstudiantes().add(estudiante);
    
        estudianteRepository.save(estudiante);
    }

}