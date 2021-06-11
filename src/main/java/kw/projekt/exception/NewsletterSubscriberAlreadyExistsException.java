package kw.projekt.exception;

public class NewsletterSubscriberAlreadyExistsException extends RuntimeException {

    public NewsletterSubscriberAlreadyExistsException(String message) {
        super(message);
    }

    public NewsletterSubscriberAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

