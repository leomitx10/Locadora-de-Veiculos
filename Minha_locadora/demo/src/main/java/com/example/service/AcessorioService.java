package com.example.service;

import java.util.List;
import com.example.demo.Acessorio;

public interface AcessorioService {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id); 
}

