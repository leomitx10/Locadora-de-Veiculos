package com.squad2.locadoradeveiculos.service;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Acessorio;

public interface AcessorioService {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id); 
}

