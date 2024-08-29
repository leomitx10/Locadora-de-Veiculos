package in.bushansirgur.springboot.crudapi.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Motorista extends Pessoa {

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
