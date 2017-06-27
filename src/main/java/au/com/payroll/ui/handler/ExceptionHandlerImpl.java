package au.com.payroll.ui.handler;


import org.apache.log4j.Logger;

/**
 * @author rnadeera
 * @see ExceptionHandler
 *
 */
public class ExceptionHandlerImpl implements ExceptionHandler {

    final static Logger logger = Logger.getLogger(ExceptionHandlerImpl.class);

    @Override
    public String handle(Exception e) {
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
