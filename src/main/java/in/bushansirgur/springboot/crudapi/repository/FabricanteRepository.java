package in.bushansirgur.springboot.crudapi.repository;

import in.bushansirgur.springboot.crudapi.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
