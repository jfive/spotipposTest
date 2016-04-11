package br.com.vivareal.spotippos.exceptions;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class SpotipposPersistenceException extends RuntimeException{

    public SpotipposPersistenceException() {
        super();
    }

    public SpotipposPersistenceException(String message) {
        super(message);
    }

    public SpotipposPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpotipposPersistenceException(Throwable cause) {
        super(cause);
    }

    protected SpotipposPersistenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
