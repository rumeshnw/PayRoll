package au.com.payroll.ui;

import au.com.payroll.dto.Employee;
import au.com.payroll.factory.ResourceFactory;
import au.com.payroll.service.PayrollService;
import au.com.payroll.ui.handler.ExceptionHandler;
import org.springframework.util.StringUtils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @see {@link Console}
 *
 * @author rnadeera
 */
public class ConsoleImpl implements Console {

    private ExceptionHandler exceptionHandler   = ResourceFactory.getExceptionHandler();
    private PayrollService payrollService       = ResourceFactory.getPayrollService();

    @Override
    public void start(){
        withScanner(scanner -> {
            String option;
            do {
                showMainMenu();
                option = scanner.nextLine();
                try {
                    switch (option){
                        case EXIT_OPTION:
                            System.out.println("See you soon. Have a nice day!!!");
                            break;
                        case "1":
                            System.out.println(generatePaySlip(scanner));
                            break;
                        default:
                            System.out.println("Invalid option. Please enter a valid option and try again.");
                            break;
                    }
                } catch (Exception e){
                    System.out.println(exceptionHandler.handle(e));
                }
            } while (!EXIT_OPTION.equals(option));
        });
    }

    private void showMainMenu(){
        System.out.println("Please select any option to proceed..");
        System.out.println("-- 1. Generate employee pay slip");
        System.out.println("-- 99. Exit the system");
    }

    private String generatePaySlip(Scanner scanner){

        System.out.println("Enter employee contact first name");
        String firstName = trimUserInput(scanner);

        System.out.println("Enter employee contact last name");
        String lastName = trimUserInput(scanner);

        System.out.println("Enter employee annual salary");
        String annualSalary = trimUserInput(scanner);

        System.out.println("Enter superannuation rate");
        String superRate = trimUserInput(scanner);

        System.out.println("Enter pay period");
        String payPeriod = trimUserInput(scanner);

        Employee employee = new Employee.EmployeeBuilder().setFirstName(firstName)
                .setLastName(lastName).setAnnualSalary(Integer.parseInt(annualSalary))
                .setSuperRate(Double.parseDouble(superRate)).setPayPeriod(payPeriod).build();
        employee.validate();

        return payrollService.generatePaySlip(employee).toString();
    }
}
