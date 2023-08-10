package com.backend.integrador.Dao.Imp;
import com.backend.integrador.Dao.H2connection;
import com.backend.integrador.Dao.IDao;
import com.backend.integrador.Entity.odontologo;
import com.backend.integrador.SqlCtes;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class OdontologoDaoH2 implements IDao<odontologo>{

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public odontologo guardar(odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            //tengo la conexion
        connection = H2connection.getConnection();

            //crear tabla

            Statement st = connection.createStatement();
            st.execute(SqlCtes.create);


            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setInt(2, odontologo.getNumeroMatricula());
            preparedStatement.setString(3, odontologo.getNombre());
            preparedStatement.setString(4, odontologo.getApellido());

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();




            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }

            connection.commit();

            LOGGER.info("se ha guardado el odontologo" + odontologo.getNombre()+"-"+odontologo.getApellido());

        }

        catch (SQLException | ClassNotFoundException exception) {
            LOGGER.error(exception.getMessage());
            exception.printStackTrace();

        }

                return odontologo;
    }

    @Override
    public List<odontologo> listarTodos() {
        Connection connection = null;
        odontologo odontologo = null;
        List<odontologo> odontologos= new ArrayList<>();


        try {

            connection = H2connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                //prueba 2
                odontologos.add(crearObjetoOdontologos(rs));
            }
            connection.commit();
            LOGGER.info("Listado de todos los odontologos: "+ odontologos);


        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();


        }


        return odontologos;
    }




    private odontologo crearObjetoOdontologos(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int numeroMatricula = resultSet.getInt("numeroMatricula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");


        return new odontologo(id,numeroMatricula,nombre,apellido);
    }


}



