package in.bushansirgur.springboot.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.bushansirgur.springboot.crudapi.model.ModeloCarro;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}
