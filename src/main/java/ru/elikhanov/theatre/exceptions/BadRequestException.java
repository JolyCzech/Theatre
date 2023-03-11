package ru.elikhanov.theatre.exceptions;

/**
 * @author Elikhanov
 */

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
