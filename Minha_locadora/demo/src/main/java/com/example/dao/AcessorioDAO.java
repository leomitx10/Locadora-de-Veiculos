package com.example.dao;

import java.util.List;
import com.example.demo.Acessorio;

public interface AcessorioDAO {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id);
}
