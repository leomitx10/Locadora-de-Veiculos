package in.bushansirgur.springboot.crudapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Funcionario extends Pessoa {
    
    private String matricula;

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

   
}
