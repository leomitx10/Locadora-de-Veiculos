package com.squad2.LocadoraDeVeiculos.demo;
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
@Table(name = "pagamento")
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