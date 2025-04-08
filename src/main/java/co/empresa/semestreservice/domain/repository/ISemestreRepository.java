package co.empresa.semestreservice.domain.repository;

import co.empresa.semestreservice.domain.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que hereda de JpaRepository para realizar las
 * operaciones de CRUD paginacion y ordenamiento sobre la entidad Semestre
 */
public interface ISemestreRepository extends JpaRepository<Semestre, Long> {
}
