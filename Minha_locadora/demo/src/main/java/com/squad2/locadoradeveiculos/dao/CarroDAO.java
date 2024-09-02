package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Carro;
import com.squad2.locadoradeveiculos.model.Categoria;

public interface CarroDAO {
    
    List<Carro> get();
    
    Carro get(Long id);
    
    void save(Carro carro);
    
    void delete(Long id); 
    
    List<Carro> getByCategoria(Categoria categoria);

    List<Carro> getByAcessorio(String acessorio);
}
