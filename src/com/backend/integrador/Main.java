package com.backend.integrador;

import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class);

        String create= "DROP TABLE IF EXIST ; CREATE TABLE (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL   ";
        String insert= "INSERT INTO";
        String delete="SELECT FROM   WHERE ID=1";
        String select= "SELECT*FROM ";



        try {
                //me conecte
            Connection connection=null;

                //creo la tabla
            Statement statement = connection.createStatement();
            //es lo mismo ejecutar la variable pasandola por parametro que escribiendo toda la sentencia
            statement.execute(create);

            //inserto a la tabla
            statement.execute(insert);

            //hacer un select para consultar la query
            ResultSet resultSet = statement.executeQuery(select);

            //recorrer el resultset

            while (resultSet.next()){

                //selecciono si quiero loggear un int o un string
                    logger.info(resultSet.getString("dsdsd"));
            }


        }
        catch (Exception exception){
            logger.error(exception.getMessage());

        }
        finally {
            try {
               // connection.close();
            }catch (Exception e){

                logger.error(e.getMessage());
            }

        }



    }

//crear el metodo para crear la conexion


    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        //indicar driver a usar

        Class.forName("org.h2.Driver");

       return DriverManager.getConnection("jdbc:h2:~/parcial","sa","sa");



    }


}
