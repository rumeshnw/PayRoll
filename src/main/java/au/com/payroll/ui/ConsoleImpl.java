package au.com.payroll.ui;

import au.com.payroll.dto.Employee;
import au.com.payroll.service.PayRollServiceImpl;
import au.com.payroll.ui.handler.ExceptionHandler;
import au.com.payroll.ui.handler.ExceptionHandlerImpl;

import java.util.regex.Pattern;

/**
 * @see {@link Console}
 *
 * @author rnadeera
 */
public class ConsoleImpl implements Console {

    private static Pattern consoleInputPattern = Pattern.compile("[A-Za-z]*,[A-Za-z]*,\\d*,\\d{1,2}(\\.\\d{1,2})?,([1-9]|1[0-2])/20\\d{2}");

    private ExceptionHandler exceptionHandler = ExceptionHandlerImpl.getInstance();

    @Override
    public void start(){
        showBanner();

        withScanner(scanner -> {
            String userInput;
            do {
                System.out.println("To generate employee pay slip, Please enter employee details in comma separated form as (firstName,lastName,AnnualSalary,superPercentage,payPeriod[MM/YYYY]). To close the application enter EXIT.");
                userInput = scanner.nextLine();

                switch (userInput){
                    case "EXIT":
                        System.out.println("Good bye. Have a nice day !!!");
                        break;
                    default:
                        if(consoleInputPattern.matcher(userInput).matches()){
                            System.out.println(generatePaySlip(userInput));
                        } else {
                            System.out.println("Invalid input format. Please enter valid format and try again (Eg: John,Doe,60500,9,3/2017).");
                        }
                        break;
                }

            } while (!EXIT_OPTION.equals(userInput));
        });
    }

    private void showBanner(){
        System.out.println("##################################################################");
        System.out.println("###################### Welcome to Pay Roll #######################");
        System.out.println("##################################################################");
    }

    private String generatePaySlip(String userInput){
        String result;
        try {
            String[] inputParams = userInput.split(",");
            Employee employee = new Employee.EmployeeBuilder().setFirstName(inputParams[0])
                    .setLastName(inputParams[1]).setAnnualSalary(Integer.parseInt(inputParams[2]))
                    .setSuperRate(Double.parseDouble(inputParams[3])).setPayPeriod(inputParams[4]).build();

            result = PayRollServiceImpl.getInstance().generatePaySlip(employee).toString();
        } catch (Exception e){
            result = exceptionHandler.translate(e);
        }
        return result;
    }




}
