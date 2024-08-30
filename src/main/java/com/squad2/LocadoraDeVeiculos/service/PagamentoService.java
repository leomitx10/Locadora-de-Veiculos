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
        List<Aluguel> alugueis = carrinho.getAlugueis();

        StringBuilder sb = new StringBuilder();
        sb.append("Carros no carrinho:\n");
        for (Carro carro : carros) {
            sb.append(String.format("ID: %d, Placa: %s, Chassi: %s, Cor: %s, Valor Diário: %.2f\n",
                    carro.getId(), carro.getPlaca(), carro.getChassi(), carro.getCor(), carro.getValorDiaria()));
        }

        sb.append("\nAluguéis no carrinho:\n");
        BigDecimal custoTotal = BigDecimal.ZERO;
        for (Aluguel aluguel : alugueis) {
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

        ApoliceSeguro apoliceSeguro = apoliceSeguroService.getApoliceSeguro(1L);
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


//class pagamento
//TODO apos revisar carrinho, confirmar reserva e efetivar aluguel > ok
//TODO pagina de resumo da reserva com detalhes > ok
//CHECK TODO informacoes: veiculo selecionado, datas, custo total e termos do aluguel > mostrar tudo novamente + soma valores
//FRONT? TODO revisar e concordar com os termos e condicoes antes de prosseguir > boolean concordar
//CHECK TODO apos concordar com os termos e condições, escolher metodo de pagamento > metodo pagamento
//CHECK TODO inserir cartao de credito ou outro metodo de pagamento > cartao, pix, boleto
//CHECK TODO opcao de confirmar o pagamento e finalizar o processo de aluguel > return no proprio meio de pagamento
//TODO apos confirmar pagamento, mostrar com todos os detalhes do aluguel, informacoes de contato e fatura > necessario outras class
