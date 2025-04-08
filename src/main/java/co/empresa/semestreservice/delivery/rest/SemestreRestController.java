package co.empresa.semestreservice.delivery.rest;

import co.empresa.semestreservice.domain.exception.NoHaySemestresException;
import co.empresa.semestreservice.domain.exception.PaginaSinSemestresException;
import co.empresa.semestreservice.domain.exception.SemestreNoEncontradoException;
import co.empresa.semestreservice.domain.exception.ValidationException;
import co.empresa.semestreservice.domain.model.Semestre;
import co.empresa.semestreservice.domain.service.ISemestreService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/semestre-service")
public class SemestreRestController {

    private final ISemestreService semestreService;

    private static final String MENSAJE = "mensaje";
    private static final String SEMESTRE = "semestre";
    private static final String SEMESTRES = "semestres";

    public SemestreRestController(ISemestreService semestreService) {
        this.semestreService = semestreService;
    }

    /**
     * Listar todos los semestres.
     */
    @GetMapping("/semestres")
    public ResponseEntity<Map<String, Object>> getSemestres() {
        List<Semestre> semestres = semestreService.findAll();
        if (semestres.isEmpty()) {
            throw new NoHaySemestresException();
        }
        Map<String, Object> response = new HashMap<>();
        response.put(SEMESTRES, semestres);
        return ResponseEntity.ok(response);
    }

    /**
     * Listar semestres con paginación.
     */
    @GetMapping("/semestre/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Semestre> semestres = semestreService.findAll(pageable);
        if (semestres.isEmpty()) {
            throw new PaginaSinSemestresException(page);
        }
        return ResponseEntity.ok(semestres);
    }

    /**
     * Crear un nuevo semestre.
     */
    @PostMapping("/semestres")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Semestre semestre, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        Map<String, Object> response = new HashMap<>();
        Semestre nuevoSemestre = semestreService.save(semestre);
        response.put(MENSAJE, "El semestre ha sido creado con éxito!");
        response.put(SEMESTRE, nuevoSemestre);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Eliminar un semestre.
     */
    @DeleteMapping("/semestres")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Semestre semestre) {
        semestreService.findById(semestre.getId())
                .orElseThrow(() -> new SemestreNoEncontradoException(semestre.getId()));
        semestreService.delete(semestre);
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "El semestre ha sido eliminado con éxito!");
        response.put(SEMESTRE, null);
        return ResponseEntity.ok(response);
    }

    /**
     * Actualizar un semestre.
     */
    @PutMapping("/semestres")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Semestre semestre, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        semestreService.findById(semestre.getId())
                .orElseThrow(() -> new SemestreNoEncontradoException(semestre.getId()));
        Map<String, Object> response = new HashMap<>();
        Semestre semestreActualizado = semestreService.update(semestre);
        response.put(MENSAJE, "El semestre ha sido actualizado con éxito!");
        response.put(SEMESTRE, semestreActualizado);
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener un semestre por su ID.
     */
    @GetMapping("/semestres/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Semestre semestre = semestreService.findById(id)
                .orElseThrow(() -> new SemestreNoEncontradoException(id));
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "El semestre ha sido encontrado con éxito!");
        response.put(SEMESTRE, semestre);
        return ResponseEntity.ok(response);
    }
}
