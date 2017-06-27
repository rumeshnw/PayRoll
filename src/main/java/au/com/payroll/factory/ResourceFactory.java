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
public class ResourceFactory {

    private ResourceFactory(){

    }

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
        return getPayPeriodGenerator(getGrossIncomeGenerator(getIncomeTaxGenerator(getNetIncomeGenerator(getSuperannuationGenerator(getEmployeePaySlipGenerator())))));
    }

    private static PaySlipGenerator getEmployeePaySlipGenerator(){
        return new EmployeePaySlipGenerator();
    }

    private static PaySlipGenerator getSuperannuationGenerator(PaySlipGenerator paySlipGenerator){
        return new SuperannuationGenerator(paySlipGenerator);
    }

    private static PaySlipGenerator getNetIncomeGenerator(PaySlipGenerator paySlipGenerator){
        return new NetIncomeGenerator(paySlipGenerator);
    }

    private static PaySlipGenerator getIncomeTaxGenerator(PaySlipGenerator paySlipGenerator){
        return new IncomeTaxGenerator(paySlipGenerator);
    }

    private static PaySlipGenerator getGrossIncomeGenerator(PaySlipGenerator paySlipGenerator){
        return new GrossIncomeGenerator(paySlipGenerator);
    }

    private static PaySlipGenerator getPayPeriodGenerator(PaySlipGenerator paySlipGenerator){
        return new PayPeriodGenerator(paySlipGenerator);
    }
}
