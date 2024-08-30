package com.squad2.LocadoraDeVeiculos.service;

import com.squad2.LocadoraDeVeiculos.model.entity.*;
import com.squad2.LocadoraDeVeiculos.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private ApoliceSeguroService apoliceSeguroService;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private AluguelService aluguelService;

    public String resumoPedido(Long carrinhoId) {

        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho == null) {
            return "Carrinho não encontrado.";
        }


        List<Carro> carros = carrinho.getCarros();
        Aluguel aluguel = carrinho.getAluguel();


        StringBuilder sb = new StringBuilder();
        sb.append("Carros no carrinho:\n");
        for (Carro carro : carros) {
            sb.append(String.format("ID: %d, Placa: %s, Chassi: %s, Cor: %s, Valor Diário: %.2f\n",
                    carro.getId(), carro.getPlaca(), carro.getChassi(), carro.getCor(), carro.getValorDiaria()));
        }


        sb.append("\nAluguel no carrinho:\n");
        BigDecimal custoTotal = BigDecimal.ZERO;

        if (aluguel != null) {
            Carro carro = aluguel.getCarro();
            if (carro != null) {
                BigDecimal valorDiaria = carro.getValorDiaria();
                long diasAluguel = ChronoUnit.DAYS.between(aluguel.getDataEntrega(), aluguel.getDataDevolucao());
                BigDecimal valorAluguel = valorDiaria.multiply(BigDecimal.valueOf(diasAluguel));
                aluguel.setValorTotal(valorAluguel);
                aluguelService.salvar(aluguel);

                sb.append(String.format("ID: %d, Data Pedido: %s, Data Entrega: %s, Data Devolução: %s, Valor Total: %.2f\n",
                        aluguel.getId(), aluguel.getDataPedido(), aluguel.getDataEntrega(), aluguel.getDataDevolucao(), valorAluguel));
                custoTotal = custoTotal.add(valorAluguel);
            }
        }


        ApoliceSeguro apoliceSeguro = apoliceSeguroService.getApoliceSeguro(1L); // Ajuste conforme necessário
        if (apoliceSeguro != null) {
            BigDecimal valorFranquia = apoliceSeguro.getValorFranquia();
            if (valorFranquia != null) {
                custoTotal = custoTotal.add(valorFranquia);
            }
        }

        sb.append("\nO custo total é: ").append(custoTotal);
        return sb.toString();
    }

    public String pagamentoCliente(Pagamento pagamento) {
        switch (pagamento.getMetodoPagamento().toLowerCase()) {
            case "cartao":
                if (isCartaoInvalido(pagamento)) {
                    return "Informações do cartão de crédito incompletas.";
                }
                return processarPagamentoCartao(
                        pagamento.getNumeroCartao(),
                        pagamento.getCodigoSeguranca(),
                        pagamento.getNomeCartao())
                        ? "Compra finalizada com sucesso."
                        : "Falha no processamento do pagamento.";


            case "pix":
                return "Pix realizado com sucesso.";

            case "boleto":
                return "Boleto gerado com sucesso.";

            default:
                return "Método de pagamento não suportado.";
        }
    }

    private boolean isCartaoInvalido(Pagamento pagamento) {
        return pagamento.getNumeroCartao() == null || pagamento.getNumeroCartao().toString().isEmpty() ||
                pagamento.getCodigoSeguranca() == null || pagamento.getCodigoSeguranca().toString().isEmpty() ||
                pagamento.getNomeCartao() == null || pagamento.getNomeCartao().isEmpty();
    }

    private boolean processarPagamentoCartao(String numeroCartao, String codigoSeguranca, String nomeCartao) {
        return true;
    }
}
