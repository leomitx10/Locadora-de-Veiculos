package com.squad2.LocadoraDeVeiculos.service;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroDAO carroDAO;

    @Transactional
    @Override
    public List<Carro> get() {
        return carroDAO.get();
    }

    @Transactional
    @Override
    public Carro get(Long id) {
        return carroDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Carro carro) {
        carroDAO.save(carro);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        carroDAO.delete(id);
    }

    @Transactional
    @Override
    public List<Carro> getByCategoria(Categoria categoria) {
        return carroDAO.getByCategoria(categoria);
    }

    @Transactional
    @Override
    public List<Carro> getByAcessorio(String acessorio) {
        return carroDAO.getByAcessorio(acessorio);
    }

}