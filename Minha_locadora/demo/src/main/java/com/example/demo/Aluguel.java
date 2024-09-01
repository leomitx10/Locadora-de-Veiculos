package com.example.demo;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    @Column(nullable = true)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "apolice_id", nullable = false)
    private ApoliceSeguro apolice;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = true)
    @JsonIgnore
    private Carrinho carrinho;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public ApoliceSeguro getApolice() {
        return apolice;
    }

    public void setApolice(ApoliceSeguro apolice) {
        this.apolice = apolice;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public String toString() {
        return "Aluguel [id=" + id + ", dataPedido=" + dataPedido + ", dataEntrega=" + dataEntrega + ", dataDevolucao="
                + dataDevolucao + ", valorTotal=" + valorTotal + ", carro=" + carro 
                + ", apolice=" + apolice + "]";
    }
}
