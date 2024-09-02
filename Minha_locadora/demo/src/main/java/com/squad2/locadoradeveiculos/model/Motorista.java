package com.squad2.locadoradeveiculos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Motorista extends Pessoa {

	@Column(nullable = false, unique = true)
	private String numeroCNH;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Motorista [numeroCNH=" + numeroCNH + ", user=" + user.getEmail() + "]";
    }
}
