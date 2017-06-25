package au.com.payroll;

import au.com.payroll.config.BootstapData;
import au.com.payroll.ui.ConsoleImpl;

/**
 * Created by rnadeera on 12/6/17.
 */
public class Application {
    public static void main(String[] args){
        initBootstrap();

        new ConsoleImpl().start();
    }

    /**
     * Contains any bootstrap related method call
     *
     */
    private static void initBootstrap(){
        new BootstapData().initData();
    }
}
