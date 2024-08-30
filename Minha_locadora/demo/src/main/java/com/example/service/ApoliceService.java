package com.example.service;

import java.util.List;
import com.example.demo.ApoliceSeguro;

public interface ApoliceService {

    List<ApoliceSeguro> get();

    ApoliceSeguro get(Long id);

    void save(ApoliceSeguro apolice);

    void delete(Long id);
}
