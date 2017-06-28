package au.com.payroll;

import au.com.payroll.config.BootstrapData;
import au.com.payroll.config.HibernateUtil;
import au.com.payroll.factory.ResourceFactory;
import au.com.payroll.ui.ConsoleImpl;

/**
 * Entry point to start the application
 *
 * @author rnadeera
 */
public class ApplicationBootstrap {

    public static void main(String[] args){
        init();
        ResourceFactory.getConsole().start();
        destroy();
    }

    /**
     * Contains bootstrap related method call
     */
    private static void init(){
        new BootstrapData().initData();
    }

    /**
     * Destroy resources before shutting down the application
     */
    private static void destroy(){
        HibernateUtil.getSessionFactory().close();
    }
}
