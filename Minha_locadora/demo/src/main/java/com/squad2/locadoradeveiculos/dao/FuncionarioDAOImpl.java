package com.squad2.locadoradeveiculos.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.squad2.locadoradeveiculos.model.Funcionario;

@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Funcionario> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Funcionario> query = currentSession.createQuery("from Funcionario", Funcionario.class);
        List<Funcionario> list = query.getResultList();
        return list;
    }

    @Override
    public Funcionario get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Funcionario funcionario = currentSession.get(Funcionario.class, id);
        return funcionario;
    }

    @Override
    public void save(Funcionario funcionario) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(funcionario);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Funcionario funcionario = currentSession.get(Funcionario.class, id);
        if (funcionario != null) {
            currentSession.delete(funcionario);
        }
    }
}
