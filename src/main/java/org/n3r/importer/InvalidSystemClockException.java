package org.n3r.importer;

class InvalidSystemClockException extends RuntimeException {
    InvalidSystemClockException(String message) {
        super(message);
    }
}
