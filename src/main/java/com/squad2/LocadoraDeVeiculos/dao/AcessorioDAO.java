package com.squad2.LocadoraDeVeiculos.dao;

public interface AcessorioDAO {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id);
}