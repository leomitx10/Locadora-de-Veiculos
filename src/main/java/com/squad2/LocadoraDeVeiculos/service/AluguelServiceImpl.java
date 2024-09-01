package com.squad2.LocadoraDeVeiculos.service;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelDAO aluguelDAO;

    @Autowired
    private ApoliceService apoliceService;

    @Autowired
    private CarroDAO carroDAO;

    @Transactional
    @Override
    public List<Aluguel> get() {
        return aluguelDAO.get();
    }

    @Transactional
    @Override
    public Aluguel get(int id) {
        return aluguelDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Aluguel aluguel) {
        if (aluguel.getDataDevolucao() != null && aluguel.getDataEntrega() != null &&
                aluguel.getCarro() != null && aluguel.getApolice() != null) {

            long diffInMillis = aluguel.getDataDevolucao().getTime() - aluguel.getDataEntrega().getTime();
            long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

            Carro carro = carroDAO.get(aluguel.getCarro().getId());
            BigDecimal valorDiaria = carro.getValorDiaria();

            ApoliceSeguro apolice = apoliceService.get(aluguel.getApolice().getId());
            BigDecimal valorFranquia = apolice.getValorFranquia();

            BigDecimal valorTotal = valorDiaria.multiply(BigDecimal.valueOf(diffInDays)).add(valorFranquia);

            aluguel.setValorTotal(valorTotal);
        }
        aluguelDAO.save(aluguel);
    }

    @Transactional
    @Override
    public void delete(int id) {
        aluguelDAO.delete(id);
    }

    @Transactional
    @Override
    public List<Aluguel> getByUserId(Long userId) {
        return aluguelDAO.getByUserId(userId);
    }
}