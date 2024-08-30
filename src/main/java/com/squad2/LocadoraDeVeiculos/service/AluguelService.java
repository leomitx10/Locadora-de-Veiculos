package com.squad2.LocadoraDeVeiculos.service;

import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.repository.AluguelRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarroRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private EntityManager entityManager;


    public String salvar(Aluguel aluguel){

        LocalDate dataEntrega = aluguel.getDataEntrega();
        LocalDate dataDevolucao = aluguel.getDataDevolucao();

        if (dataDevolucao == null || dataEntrega == null) {
            return "Data de entrega ou data de devolução não podem ser nulas.";
        }

        if (dataDevolucao.isBefore(dataEntrega)) {
            return "Data de devolução deve ser no mesmo dia ou após a data de entrega.";
        }

        aluguelRepository.save(aluguel);
        return "Aluguel salvo.";
    }

    public List<Aluguel> listar(){
        return aluguelRepository.findAll();
    }

    public String modificar(Aluguel aluguel){
        LocalDate dataEntrega = aluguel.getDataEntrega();
        LocalDate dataDevolucao = aluguel.getDataDevolucao();

        if (dataDevolucao == null || dataEntrega == null) {
            return "Data de entrega ou data de devolução não podem ser nulas.";
        }

        if (dataDevolucao.isBefore(dataEntrega)) {
            return "Data de devolução deve ser no mesmo dia ou após a data de entrega.";
        }

        aluguelRepository.save(aluguel);
        return "Aluguel modificado.";
    }


    public String deletar(Long id){
        aluguelRepository.deleteById(id);
        return "Exclusão de aluguel realizada.";
    }

    public void resetarIdAluguel() {
        entityManager.createNativeQuery("ALTER TABLE alugueis AUTO_INCREMENT = 1")
                .executeUpdate();
    }

    public void calcularValorTotalAluguel(Long aluguelId, Long carroId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElse(null);
        Carro carro = carroRepository.findById(carroId).orElse(null);

        if (aluguel != null && carro != null) {
            long diasAluguel = ChronoUnit.DAYS.between(aluguel.getDataEntrega(), aluguel.getDataDevolucao());
            BigDecimal valorTotal = carro.getValorDiaria().multiply(BigDecimal.valueOf(diasAluguel));
            aluguel.setValorTotal(valorTotal);
            aluguelRepository.save(aluguel);
        }
    }
}
    //OK TODO selecionar periodo aluguel inicio e termino > crud feito
    //OK TODO crud apolice seguro

    //CARRINHO
    //TODO adicionar veiculo ao carrinho de aluguel > criar associação veiculo(veiculo precisa de crud)
    // aluguel relacao de 1 p 1
    //TODO exibir resumo carrinho aluguel > exibir resumo aluguel e veiculo
    //TODO cliente revisar carrinho e alterar > fazer crud(modificar)
    //TODO mostrar um print na tela de confirmação com detalhes da reserva > mostrar informações (dados inseridos)
    //class pagamento
    //TODO apos revisar carrinho, confirmar reserva e efetivar aluguel
    //TODO pagina de resumo da reserva com detalhes
    //TODO infromacoes: veiculo selecionado, datas, custo total e termos do aluguel
    //TODO revisar e concordar com os termos e condicoes antes de prosseguir
    //TODO apos concordar com os termos e condições, escolher metodo de pagamento
    //TODO inserir cartao de credito ou outro metodo de pagamento
    //TODO opcao de confirmar o pagamento e finalizar o processo de aluguel
    //TODO apos confirmar pagamento, mostrar com todos os detalhes do aluguel, informacoes de contato e fatura

    //QUAL CLASS?
    //TODO sistema deve marcar o veiculo como reservado e bloquear as datas de aluguel
    //FAZER PERCORRER TODO O BANCO DE DADOS PARA VER SE O VEICULO ESTA EM USO
    //FAZER PERCORRER PARA VER DATAS QUE O VEICULO N ESTA DISPONIVEL
    //TODO cliente pode acessar seus alugueis confirmados e detalhes futuros atraves da conta > class cliente MOSTRAR CADASTRO, ALUGUEL E CARRO