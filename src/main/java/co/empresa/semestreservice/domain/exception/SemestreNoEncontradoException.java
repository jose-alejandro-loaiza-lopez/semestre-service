package co.empresa.semestreservice.domain.exception;

public class SemestreNoEncontradoException extends RuntimeException {
    public SemestreNoEncontradoException(Long id) {
        super("El semestre con ID " + id + " no fue encontrado.");
    }
}