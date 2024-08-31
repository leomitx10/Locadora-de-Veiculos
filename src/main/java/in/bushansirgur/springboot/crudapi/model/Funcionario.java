package in.bushansirgur.springboot.crudapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {
    
    private String matricula;

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


	/*
	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + "]";
	}*/
    
}
