package au.com.payroll.ui.handler;


import org.apache.log4j.Logger;

/**
 * @author rnadeera
 * @see ExceptionHandler
 *
 */
public class ExceptionHandlerImpl implements ExceptionHandler {

    final static Logger logger = Logger.getLogger(ExceptionHandlerImpl.class);

    private static ExceptionHandler exceptionHandler;

    private ExceptionHandlerImpl(){

    }

    public static ExceptionHandler getInstance(){
        exceptionHandler = exceptionHandler == null ? new ExceptionHandlerImpl():exceptionHandler;
        return exceptionHandler;
    }

    @Override
    public String translate(Exception e) {
        String message;
        if (e instanceof IllegalArgumentException) {
            message = e.getMessage();
        } else {
            logger.error("Something went wrong!", e);
            message = "Something went wrong.  Please contact Administrator.";
        }
        return message;
    }
}
