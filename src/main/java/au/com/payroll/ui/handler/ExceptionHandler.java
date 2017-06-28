package au.com.payroll.ui.handler;

import org.apache.log4j.Logger;

/**
 * Implement this to handle Exceptions.
 *
 * @author rnadeera
 */
public interface ExceptionHandler {

    Logger logger = Logger.getLogger(ExceptionHandlerImpl.class);

    default String handle(Exception e) {
        String message;
        if(e instanceof NumberFormatException){
            message = "Invalid input for numeric value";
        } else if (e instanceof IllegalArgumentException) {
            message = e.getMessage();
        } else {
            logger.error("System Error", e);
            message = "Application malfunctioned.  Please contact Administrator.";
        }
        return message;
    }
}
