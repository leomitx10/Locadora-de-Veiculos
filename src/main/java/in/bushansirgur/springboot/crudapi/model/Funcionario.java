package in.bushansirgur.springboot.crudapi.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
public class Funcionario extends Pessoa {
    
    private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + "]";
	}
    
}
