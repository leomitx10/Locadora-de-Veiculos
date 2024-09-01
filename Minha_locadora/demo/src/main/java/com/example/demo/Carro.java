package com.example.demo;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false, unique = true)
    private String chassi;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private BigDecimal valorDiaria;
    
    @Column(nullable = false)
    private Boolean reservado = false;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id", nullable = false)
    private ModeloCarro modeloCarro;

    @OneToMany
    @JoinColumn(name = "acessorio_id",nullable = true)
    private List<Acessorio> acessorios;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Boolean getReservado() {
		return reservado;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public ModeloCarro getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(ModeloCarro modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", chassi='" + chassi + '\'' +
                ", cor='" + cor + '\'' +
                ", valorDiaria=" + valorDiaria +
                ", modeloCarro=" + modeloCarro.getDescricao() +
                ", acessorios=" + acessorios +
                '}';
    }
}
