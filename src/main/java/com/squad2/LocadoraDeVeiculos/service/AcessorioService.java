package com.squad2.LocadoraDeVeiculos.service;

import com.squad2.LocadoraDeVeiculos.model.entity.Acessorio;

import java.util.List;

public interface AcessorioService {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id);
}