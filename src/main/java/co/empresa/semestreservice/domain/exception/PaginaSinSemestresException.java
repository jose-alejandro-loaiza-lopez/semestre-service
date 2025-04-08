package co.empresa.semestreservice.domain.exception;

public class PaginaSinSemestresException extends RuntimeException {
    public PaginaSinSemestresException(int page) {
        super("No hay semestres en la página solicitada: " + page);
    }
}