package com.squad2.locadoradeveiculos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluguel> alugueis;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public String resumo() {
        List<Aluguel> alugueis = this.getAlugueis();
        BigDecimal custoTotal = alugueis.stream()
                                        .map(Aluguel::getValorTotal)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        StringBuilder resumo = new StringBuilder();
        resumo.append("Resumo do Carrinho:\n");

        for (Aluguel aluguel : alugueis) {
            Carro carro = aluguel.getCarro();
            resumo.append("\nVeículo: ").append(carro.getModeloCarro().getDescricao());
            resumo.append("\nPlaca: ").append(carro.getPlaca());
            resumo.append("\nData de Aluguel: ").append(aluguel.getDataEntrega()).append(" - ").append(aluguel.getDataDevolucao()).append("\n");
        }

        resumo.append("\nCusto total estimado: R$").append(custoTotal);

        return resumo.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
