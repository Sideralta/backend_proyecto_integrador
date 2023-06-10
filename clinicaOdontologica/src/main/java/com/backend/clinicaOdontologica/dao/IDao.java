package com.backend.clinicaOdontologica.dao;

import java.util.List;

public interface IDao<T> {
    T guardar(T t);

    List<T> listarTodos();

    T buscarPorId(int id);

    T buscarPorCriterio(String dni);

    void eliminar(int id);

    T actualizar(T t);
}
