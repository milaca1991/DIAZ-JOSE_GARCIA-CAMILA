package com.backend.integrador.test;

import com.backend.integrador.Dao.IDao;
import com.backend.integrador.Dao.Imp.OdontologoDaoH2;
import com.backend.integrador.Entity.odontologo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestOdontologoDao {

private static final IDao<odontologo> odontologoDao = new OdontologoDaoH2();



    @BeforeClass
public static void debeGuardarOdontologos(){

        odontologoDao.guardar(new odontologo(1,123,"camila","garcia"));
        odontologoDao.guardar(new odontologo(2,124,"jose","diaz"));
        odontologoDao.guardar(new odontologo(3,555,"juan","gomez"));
    }

    @Test
    public  void traerTodosLosOdontologosTest() {
        List<odontologo> odontologos = odontologoDao.listarTodos();
        Assert.assertTrue(odontologos.size() > 0);
    }

}
