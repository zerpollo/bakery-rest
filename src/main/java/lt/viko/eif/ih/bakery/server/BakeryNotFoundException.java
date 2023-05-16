package lt.viko.eif.ih.bakery.server;

/**
 * Exception handler if the bakery with the given ID is not found.
 */


public class BakeryNotFoundException extends RuntimeException {
    BakeryNotFoundException(Long id) {
        super("Could not find bakery " + id);
    }
}
