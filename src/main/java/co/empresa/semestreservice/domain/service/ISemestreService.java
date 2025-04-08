package co.empresa.semestreservice.domain.service;

import co.empresa.semestreservice.domain.model.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interface que define los métodos que se pueden realizar sobre la entidad Semestre
 */
public interface ISemestreService {
    Semestre save(Semestre semestre);
    void delete(Semestre semestre);
    Optional<Semestre> findById(Long id);
    Semestre update(Semestre semestre);
    List<Semestre> findAll();
    Page<Semestre> findAll(Pageable pageable);
}
