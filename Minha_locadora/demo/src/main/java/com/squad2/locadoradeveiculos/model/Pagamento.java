package com.squad2.locadoradeveiculos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "pagamento")
public class Pagamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String numeroCartao;

    @Column(length = 4, nullable = false)
    private String codigoSeguranca;

    @Column(nullable = false)
    private String nomeCartao;

    @Column(nullable = false)
    private String metodoPagamento;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

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

//class pagamento
//TODO apos revisar carrinho, confirmar reserva e efetivar aluguel > ok
//TODO pagina de resumo da reserva com detalhes > ok
//CHECK TODO informacoes: veiculo selecionado, datas, custo total e termos do aluguel > mostrar tudo novamente + soma valores
//FRONT? TODO revisar e concordar com os termos e condicoes antes de prosseguir > boolean concordar
//CHECK TODO apos concordar com os termos e condições, escolher metodo de pagamento > metodo pagamento
//CHECK TODO inserir cartao de credito ou outro metodo de pagamento > cartao, pix, boleto
//CHECK TODO opcao de confirmar o pagamento e finalizar o processo de aluguel > return no proprio meio de pagamento
//TODO apos confirmar pagamento, mostrar com todos os detalhes do aluguel, informacoes de contato e fatura > necessario outras class

