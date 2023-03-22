package fr.kira.formation.exercice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j // <=> private static final Logger log = LoggerFactory.getLogger(NotFoundException.class);
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<NotFoundResponse> handleException(NotFoundException exception) {
        log.warn("Erreur 404: " + exception.getMessage());
        return new ResponseEntity<>(
                new NotFoundResponse(exception.getReason()),
                HttpStatus.NOT_FOUND
        );
    }
}
