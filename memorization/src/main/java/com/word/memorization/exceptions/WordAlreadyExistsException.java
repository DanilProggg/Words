package com.word.memorization.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Слово уже существует в базе данных")
public class WordAlreadyExistsException extends RuntimeException {

    public WordAlreadyExistsException() {
        super("Слово уже существует в базе данных");
    }

    public WordAlreadyExistsException(String message) {
        super(message);
    }

    public WordAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
