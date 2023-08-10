//package com.backend.integrador;
//
//
//import com.backend.integrador.Dao.H2connection;
//import org.apache.log4j.Logger;
//
//import java.sql.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Logger logger = Logger.getLogger(Main.class);
//
//
//        Connection connection=null;
//
//        try {
//                //me conecte
//
//            connection= H2connection.getConnection();
//
//                //creo la tabla
//            Statement statement = connection.createStatement();
//            //es lo mismo ejecutar la variable pasandola por parametro que escribiendo toda la sentencia
//            statement.execute(SqlCtes.create);
//
//            //inserto a la tabla
//            statement.execute(SqlCtes.insert);
//
//            //hacer un select para consultar la query
//            ResultSet resultSet = statement.executeQuery(SqlCtes.select);
//
//            //recorrer el resultset
//
//            while (resultSet.next()){
//
//                //selecciono si quiero loggear un int o un string
//                    logger.info(resultSet.getInt("id")+ "-"+resultSet.getString("nombre")+"-"+resultSet.getString("tipo"));
//
//            }
//
//
//        }
//        catch (Exception exception){
//            logger.error(exception.getMessage());
//
//        }
//        finally {
//            try {
//
//                connection.close();
//            }catch (Exception e){
//
//                logger.error(e.getMessage());
//            }
//
//        }
//
//
//
//    }
//
////crear el metodo para crear la conexion
//
//
//
//    //esto va en clase h2Connection en carpeta impl que la contiene dao
//
//
//
//}
