package com.TP.IS3.GRUPO3.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Aula;
import com.TP.IS3.GRUPO3.domain.Espacio;
import com.TP.IS3.GRUPO3.repositorys.IEspacioRepository;
import com.TP.IS3.GRUPO3.services.IEspacioService;

@Service
public class EspacioService implements IEspacioService {

    @Autowired
    private IEspacioRepository espacioRepository;

    @Override
    public List<Espacio> getAll() {
        return espacioRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Espacio espacio) {
        try {
            espacioRepository.save(espacio);
            return true;
        } catch (Exception he) {
            return false;
        }
    }

    @Override
    public Espacio findById(int id) {
        return espacioRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            espacioRepository.deleteById(id);
            return true;
        } catch (Exception he) {
            return false;
        }
    }

    @Override
    public Espacio traer(LocalDate fecha, char turno, Aula aula) {
        /*
         * Espacio ee = null;
         * List<Espacio> t = getAll();
         * for(Espacio e : t) {
         * if(e.getFecha().isEqual(fecha) && e.getTurno() == turno &&
         * e.getAula().getId() == aula.getId()) {}
         * ee = e;
         * }
         * return ee;
         */
        return espacioRepository.traer(fecha, turno, aula);
    }

    @Override
    public boolean agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {
        Espacio e = traer(fecha, turno, aula);
        if (e != null) {
            throw new Exception("Ya existe ese espacio!");
        }
        Espacio es = new Espacio(fecha, turno, aula, libre);

        try {
            espacioRepository.save(es);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception {
        List<Espacio> aux = espacioRepository.findAll();
        for (Espacio pp : aux) {
            LocalDate hoy = LocalDate.now();
            LocalDate maniana = hoy.plusDays(1);
            LocalDate fecha = traerFecha(anio, mes, maniana.getDayOfMonth());
            Espacio espacio = this.traer(fecha, pp.getTurno(), pp.getAula());
            if (espacio.isLibre()) {
                agregar(pp.getFecha(), turno, aula, true);
            }
        }

    }

    public static LocalDate traerFecha(int anio, int mes, int dia) {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        return fecha;
    }

}
