import java.util.Locale;
import java.util.Scanner;


public class Calculator {

    /**
     * Method to execute calculator
     */
    public void startCalculator(){
        double first = 0;
        double second = 0;

        System.out.println("Welcome to simple calculator");
        Scanner myObj = new Scanner(System.in);
        mathOperationsToChoose();
        String userEquationChoice = myObj.nextLine();

        boolean loop = !isValidInput(userEquationChoice);

        while(loop){
            System.out.println("Ups, something went wrong, please choose on option below");
            mathOperationsToChoose();
            userEquationChoice = myObj.nextLine();
            loop = !isValidInput(userEquationChoice);
        }

        first = getFirstNumber();
        second = getSecondNumber();
        checkNumbersAndCalculate(userEquationChoice,first, second);

    }

    /**
     * Simple method to generate text
      */
    private void mathOperationsToChoose(){
        System.out.println("Please choose what mathematical operation would you like to choose");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
    }

    /**
     * method to get first number from user input, has simple validation for numeric value
     *
     * @return
     */
    protected static double getFirstNumber() {
        double first = 0;
        Scanner firstNumber = new Scanner(System.in);
        System.out.println("Please enter first number");
        if(firstNumber.hasNextDouble()){
            first = firstNumber.nextDouble();
        } else {
            System.out.println("Please provide numerical value");
            first = getFirstNumber();
        }

        return first;
    }

    /**
     * method to get second number from user input, has simple validation for numeric value
     *
     * @return
     */
    protected static double getSecondNumber() {
        double second = 0;
        Scanner secondNumber = new Scanner(System.in);
        System.out.println("Please enter second number");
        if(secondNumber.hasNextDouble()){
            second = secondNumber.nextDouble();
        } else {
            System.out.println("Please provide numerical value");
            second = getFirstNumber();
        }
        return second;
    }

    /**
     * Method to validate user input
     * @param input
     * @return
     */
    private boolean isValidInput(String input){
        return  MathConstants.ADDITION.equalsIgnoreCase(input) ||
                MathConstants.SUBTRACTION.equalsIgnoreCase(input) ||
                MathConstants.MULTIPLICATION.equalsIgnoreCase(input) ||
                MathConstants.DIVISION.equalsIgnoreCase(input);
    }

    private static void checkNumbersAndCalculate(String userEquationChoice, double first, double second) {

        Scanner userChoice = new Scanner(System.in);
        System.out.println("Are you happy with passed numbers: " + first + " " + second);
        System.out.println("Yes/No");
        String simpleChoice = userChoice.nextLine();
        if("no".equalsIgnoreCase(simpleChoice)) {
            first = getFirstNumber();
            second = getSecondNumber();
            checkNumbersAndCalculate(userEquationChoice,first, second);
        } else if("yes".equalsIgnoreCase(simpleChoice)){
            equate(userEquationChoice,first, second);
        } else {
            System.out.println("Ups! Something went wrong, please choose either yes or no");
            checkNumbersAndCalculate(userEquationChoice,first, second);

        }

    }

    private static void equate(String userEquationChoice, double first, double second) {
        switch (userEquationChoice.toLowerCase(Locale.ROOT)){
            case MathConstants.ADDITION:
                CalculatorHelper.addition(first, second);
                break;
            case MathConstants.SUBTRACTION:
                CalculatorHelper.subtraction(first, second);
                break;
            case MathConstants.MULTIPLICATION:
                CalculatorHelper.multiplication(first, second);
                break;
            case MathConstants.DIVISION:
                CalculatorHelper.division(first, second);
                break;
        }

    }
}
