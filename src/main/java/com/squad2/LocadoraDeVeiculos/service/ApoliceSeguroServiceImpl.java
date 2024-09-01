package com.squad2.LocadoraDeVeiculos.service;

@Service
public class ApoliceServiceImpl implements ApoliceService {

    @Autowired
    private ApoliceDAO apoliceDAO;

    @Transactional(readOnly = true)
    @Override
    public List<ApoliceSeguro> get() {
        return apoliceDAO.get();
    }

    @Transactional(readOnly = true)
    @Override
    public ApoliceSeguro get(Long id) {
        return apoliceDAO.get(id);
    }

    @Transactional
    @Override
    public void save(ApoliceSeguro apolice) {
        apoliceDAO.save(apolice);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        apoliceDAO.delete(id);
    }
}