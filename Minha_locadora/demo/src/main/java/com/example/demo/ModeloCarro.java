package com.example.demo;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "modelo_carro")
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    private Fabricante fabricante;

    @OneToMany(mappedBy = "modeloCarro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Carro> carros;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ModeloCarro [id=" + id + ", descricao=" + descricao + ", fabricante=" + fabricante + ", carros="
				+ carros + ", categoria=" + categoria + "]";
	}

    
}
