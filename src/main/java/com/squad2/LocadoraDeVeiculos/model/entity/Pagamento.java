package com.squad2.LocadoraDeVeiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pagamentos")
public class Pagamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal custoTotal;

    @Column(length = 16, nullable = false)
    private String numeroCartao;

    @Column(length = 4, nullable = false)
    private String codigoSeguranca;

    @Column(nullable = false)
    private String nomeCartao;

    @Column(nullable = false)
    private String metodoPagamento;


    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;
}
//class pagamento
//TODO apos revisar carrinho, confirmar reserva e efetivar aluguel > ok
//TODO pagina de resumo da reserva com detalhes > ok
//TODO informacoes: veiculo selecionado, datas, custo total e termos do aluguel > mostrar tudo novamente + soma valores
//TODO revisar e concordar com os termos e condicoes antes de prosseguir > boolean concordar
//TODO apos concordar com os termos e condições, escolher metodo de pagamento > metodo pagamento
//TODO inserir cartao de credito ou outro metodo de pagamento > cartao, pix, boleto
//TODO opcao de confirmar o pagamento e finalizar o processo de aluguel > return no proprio meio de pagamento
//TODO apos confirmar pagamento, mostrar com todos os detalhes do aluguel, informacoes de contato e fatura > necessario outras class
