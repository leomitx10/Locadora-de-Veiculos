package in.bushansirgur.springboot.crudapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Motorista extends Pessoa {
    private String numeroCNH;
    
	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	@Override
	public String toString() {
		return "Motorista [numeroCNH=" + numeroCNH + "]";
	}

}
