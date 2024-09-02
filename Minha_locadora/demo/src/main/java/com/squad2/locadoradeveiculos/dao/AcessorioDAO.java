package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Acessorio;

public interface AcessorioDAO {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id);
}
