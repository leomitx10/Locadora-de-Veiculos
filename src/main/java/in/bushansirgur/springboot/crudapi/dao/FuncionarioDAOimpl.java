package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.model.Funcionario;
import jakarta.persistence.EntityManager;

@Repository
public class FuncionarioDAOimpl implements FuncionarioDAO {
    
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Funcionario> get() {
        return entityManager.createQuery("from Funcionario", Funcionario.class).getResultList();
    }

    @Override
    @Transactional
    public Funcionario get(int id) {
        return entityManager.find(Funcionario.class, id);
    }

    @Override
    @Transactional
    public Funcionario save(Funcionario funcionario) {
        if (funcionario.getId() == null) {
            entityManager.persist(funcionario);
            return funcionario;
        } else {
            return entityManager.merge(funcionario);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Funcionario funcionario = get(id);
        if (funcionario != null) {
            entityManager.remove(funcionario);
        }
    }
}
