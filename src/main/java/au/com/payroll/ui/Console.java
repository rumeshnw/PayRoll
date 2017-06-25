package au.com.payroll.ui;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Interface to handle CLI. Implement this to handle different CLI logic
 *
 * Created by rnadeera on 25/6/17.
 */
public interface Console {

    void start();

    default void withScanner(Consumer<Scanner> consumer){
        Scanner scanner = new Scanner(System.in);
        try {
            consumer.accept(scanner);
        } finally {
            scanner.close();
        }
    }

    default String trimUserInput(Scanner scanner){
        String strValue = StringUtils.trim(scanner.nextLine());
        return StringUtils.isEmpty(strValue) ? null : strValue;
    }
}
