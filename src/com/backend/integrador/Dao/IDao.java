package com.backend.integrador.Dao;


import java.util.List;

//
public interface IDao <T>{

//metodos de la interfaz

    T guardar(T t);
    List<T> listarTodos();


}
