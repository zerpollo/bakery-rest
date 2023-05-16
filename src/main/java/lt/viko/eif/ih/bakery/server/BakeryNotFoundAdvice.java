package lt.viko.eif.ih.bakery.server;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice class for handling exceptions related to bakery not found.
 */

@ControllerAdvice
public class BakeryNotFoundAdvice {

    /**
     * Exception handler for BakeryNotFoundException.
     *
     * @param ex the BakeryNotFoundException object
     * @return the error message as a string
     */

    @ResponseBody
    @ExceptionHandler(BakeryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bakerynotFoundHandler(BakeryNotFoundException ex) {
        return ex.getMessage();
    }
}
