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
public class Motorista extends Pessoa {

    private String numeroCNH;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /* Caso seja necessario
    @Override
    public String toString() {
    return "Motorista [numeroCNH=" + numeroCNH + ", user=" + user.getEmail() + "]";
    }
    */
}
