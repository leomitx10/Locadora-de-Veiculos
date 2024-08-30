package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.crudapi.model.ModeloCarro;

@Repository
@Transactional
public class ModeloCarroDAOImpl implements ModeloCarroDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ModeloCarro modeloCarro) {
        entityManager.persist(modeloCarro);
    }

    @Override
    public List<ModeloCarro> getAll() {
        return entityManager.createQuery("from ModeloCarro", ModeloCarro.class).getResultList();
    }

    @Override
    public ModeloCarro getById(Long id) {
        return entityManager.find(ModeloCarro.class, id);
    }

    @Override
    public void update(ModeloCarro modeloCarro) {
        entityManager.merge(modeloCarro);
    }

    @Override
    public void delete(Long id) {
        ModeloCarro modeloCarro = getById(id);
        if (modeloCarro != null) {
            entityManager.remove(modeloCarro);
        }
    }
}
