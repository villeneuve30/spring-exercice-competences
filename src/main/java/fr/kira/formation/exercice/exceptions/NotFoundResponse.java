package fr.kira.formation.exercice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundResponse {
    private LocalDateTime timestamp = LocalDateTime.now();

    private String message;

    public NotFoundResponse(String message) {
        this.message = message;
    }
}
