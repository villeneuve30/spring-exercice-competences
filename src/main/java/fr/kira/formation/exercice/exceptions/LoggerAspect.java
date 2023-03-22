package fr.kira.formation.exercice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
    @AfterThrowing
    public void before(JoinPoint jp) {
        log.warn("Erreur 404: " + jp.getSignature().getName());
    }
}
