package co.empresa.semestreservice.domain.exception;

public class NoHaySemestresException extends RuntimeException {
    public NoHaySemestresException() {
        super("No hay semestres en la base de datos.");
    }
}