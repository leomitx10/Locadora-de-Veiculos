package com.squad2.LocadoraDeVeiculos.dao;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;

import java.util.List;

public interface CarroDAO {

    List<Carro> get();

    Carro get(Long id);

    void save(Carro carro);

    void delete(Long id);

    List<Carro> getByCategoria(Categoria categoria);

    List<Carro> getByAcessorio(String acessorio);
}