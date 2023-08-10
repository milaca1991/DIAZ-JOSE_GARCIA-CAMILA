package com.backend.integrador.Dao.Imp;

import com.backend.integrador.Dao.IDao;
import com.backend.integrador.Entity.odontologo;

import java.util.List;


public class OdontologoDaoEnMemoria implements IDao<odontologo> {

    private List<odontologo> odontologoRepositorio;

    public OdontologoDaoEnMemoria(List<odontologo> odontologoRepositorio){

        this.odontologoRepositorio=odontologoRepositorio;
    }


    @Override
    public odontologo guardar(odontologo odontologo) {

        odontologoRepositorio.add(odontologo);
        return odontologo;
    }

    @Override
    public List<odontologo> listarTodos() {
        return odontologoRepositorio;
    }
}
