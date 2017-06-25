package au.com.payroll.ui;

import au.com.payroll.domain.IncomeTax;
import au.com.payroll.dto.Employee;
import au.com.payroll.repository.IncomeTaxRepositoryImpl;
import au.com.payroll.service.PayRollServiceImpl;

/**
 * @see {@link Console}
 *
 * @author rnadeera
 */
public class ConsoleImpl implements Console {

    @Override
    public void start(){

        Employee employee = new Employee.EmployeeBuilder().setFirstName("John")
                                    .setLastName("Doe").setAnnualSalary(120000)
                                    .setPayPeriod("08/2017").setSuperRate(10).build();

        System.out.println(PayRollServiceImpl.getInstance().generatePaySlip(employee).toString());
    }


}
