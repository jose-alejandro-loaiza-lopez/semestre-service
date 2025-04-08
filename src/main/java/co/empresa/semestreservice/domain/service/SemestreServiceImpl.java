package co.empresa.semestreservice.domain.service;

import co.empresa.semestreservice.domain.model.Semestre;
import co.empresa.semestreservice.domain.repository.ISemestreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa los métodos de la interfaz ISemestreService
 * para realizar las operaciones de negocio sobre la entidad Semestre
 */
@Service
public class SemestreServiceImpl implements ISemestreService {

    private final ISemestreRepository semestreRepository;

    public SemestreServiceImpl(ISemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    @Override
    @Transactional
    public Semestre save(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    @Override
    @Transactional
    public void delete(Semestre semestre) {
        semestreRepository.delete(semestre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Semestre> findById(Long id) {
        return semestreRepository.findById(id);
    }

    @Override
    @Transactional
    public Semestre update(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Semestre> findAll() {
        return semestreRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Semestre> findAll(Pageable pageable) {
        return semestreRepository.findAll(pageable);
    }
}
