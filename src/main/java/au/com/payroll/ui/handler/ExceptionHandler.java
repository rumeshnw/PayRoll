package au.com.payroll.ui.handler;

/**
 * Implement this to handle Exceptions.
 *
 * @author rnadeera
 */

public interface ExceptionHandler {

    /**
     * Convert Exception into user readable message
     *
     * @param e {@link Exception}
     * @return {@link String} a User readable message
     * */
    String handle(Exception e);
}
