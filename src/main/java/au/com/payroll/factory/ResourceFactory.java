package au.com.payroll.factory;

import au.com.payroll.repository.IncomeTaxRepositoryImpl;
import au.com.payroll.repository.IncomeTaxRespository;
import au.com.payroll.service.PayrollService;
import au.com.payroll.service.PayrollServiceImpl;
import au.com.payroll.service.process.*;
import au.com.payroll.ui.handler.ExceptionHandler;
import au.com.payroll.ui.handler.ExceptionHandlerImpl;

/**
 * Factory to create instance of several resources across application
 *
 * @author rnadeera
 */
public abstract class ResourceFactory {

    public static PayrollService getPayrollService(){
        return new PayrollServiceImpl();
    }

    public static IncomeTaxRespository getIncomeTaxRespository(){
        return new IncomeTaxRepositoryImpl();
    }

    public static ExceptionHandler getExceptionHandler(){
        return new ExceptionHandlerImpl();
    }

    public static PaySlipGenerator getPaySlipGenerator(){
        return new PayPeriodGenerator(new GrossIncomeGenerator(new IncomeTaxGenerator(new NetIncomeGenerator(new SuperannuationGenerator(new EmployeePaySlipGenerator())))));
    }
}
