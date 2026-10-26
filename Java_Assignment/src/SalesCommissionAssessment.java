/**
 * @author : Dimpho Phala
 * Date : 10/25/2026
 **/
import java.util.Scanner;

public class SalesCommissionAssessment {
    static Scanner input = new Scanner(System.in);

    static String[] arPersons = new String[4];
    static double[][] arSales = new double[4][4];

    static double BASIC_WAGE = 7500.00;
    static double COMMISSION_RATE = 0.10;

    // Initialise the arrays
    public static void Initialize() {

        arPersons[0] = "Thabo";
        arPersons[1] = "Loraine";
        arPersons[2] = "Zama";
        arPersons[3] = "Peter";

        arSales[0] = new double[]{17550, 14500, 11000, 12500};
        arSales[1] = new double[]{15000, 12000, 12500, 16800};
        arSales[2] = new double[]{15620, 18100, 21500, 17630};
        arSales[3] = new double[]{15755, 13900, 12950, 19200};
    }

    // Find a salesperson by name
    public static int findSalesPerson(String name) {

        for (int i = 0; i < arPersons.length; i++) {

            if (arPersons[i].equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    // Calculate the monthly sales of a salesperson
    public static double calcTotalMonthlySales() {

        System.out.print("Enter salesperson's name: ");
        String name = input.nextLine();

        int position = findSalesPerson(name);

        if (position == -1) {
            System.out.println("Salesperson not found.");
            return 0;
        }

        double total = 0;

        for (int i = 0; i < arSales[position].length; i++) {
            total += arSales[position][i];
        }
        System.out.print("Total Sales for " + arPersons[position] + ": ");
        return total;

    }

    // Calculate monthly salary
    public static double calcMonthlySalary() {

        System.out.print("Enter salesperson's name: ");
        String name = input.nextLine();

        int position = findSalesPerson(name);

        if (position == -1) {
            System.out.println("Salesperson not found.");
            return 0;
        }

        double monthlySales = 0;

        for (int i = 0; i < arSales[position].length; i++) {
            monthlySales += arSales[position][i];
        }

        double commission = monthlySales * COMMISSION_RATE;
        System.out.print("Monthly Salary for " + arPersons[position] + ": ");
        return BASIC_WAGE + commission;
    }

    // Calculate company monthly turnover
    public static double calcMonthlyTurnOver() {

        double turnover = 0;

        for (int i = 0; i < arSales.length; i++) {

            for (int j = 0; j < arSales[i].length; j++) {
                turnover += arSales[i][j];
            }
        }

        return turnover;
    }

    // Calculate total monthly salary expenditure
    public static double calcSalaryExpenditure() {

        double expenditure = 0;

        for (int i = 0; i < arPersons.length; i++) {

            double monthlySales = 0;

            for (int j = 0; j < arSales[i].length; j++) {
                monthlySales += arSales[i][j];
            }

            expenditure += BASIC_WAGE
                    + (monthlySales * COMMISSION_RATE);
        }

        return expenditure;
    }

    // Find and display the best salesperson
    public static void getBestSalesPerson() {

        int bestPosition = 0;
        double highestSales = 0;

        for (int i = 0; i < arPersons.length; i++) {

            double monthlySales = 0;

            for (int j = 0; j < arSales[i].length; j++) {
                monthlySales += arSales[i][j];
            }

            if (monthlySales > highestSales) {
                highestSales = monthlySales;
                bestPosition = i;
            }
        }

        System.out.println("Best Salesperson");
        System.out.println(arPersons[bestPosition]);
        System.out.println(highestSales);
    }

    // Display all salespeople and their weekly sales
    public static void display() {

        System.out.printf("%-12s %12s %12s %12s %12s %15s%n",
                "Name", "Week 1", "Week 2",
                "Week 3", "Week 4", "Monthly Sales");

        for (int i = 0; i < arPersons.length; i++) {

            double total = 0;

            System.out.printf("%-12s", arPersons[i]);

            for (int j = 0; j < arSales[i].length; j++) {

                System.out.printf("%12.2f", arSales[i][j]);
                total += arSales[i][j];
            }

            System.out.printf("%15.2f%n", total);
        }
    }

    // Main menu

    public static void main(String[] args) {

        Initialize();

        String answer;

        do {
            System.out.println("\nPlease select a menu item below:");
            System.out.println("1 - See All Salespeople");
            System.out.println("2 - Find Salesperson");
            System.out.println("3 - Total Monthly Sales");
            System.out.println("4 - Monthly Salary");
            System.out.println("5 - Best Salesperson");
            System.out.println("6 - Monthly Turnover");
            System.out.println("7 - Total Salary Expenditure");

            System.out.print("Your Option: ");

            int choice;

            while (!input.hasNextInt()) {
                System.out.print("Please enter a number from 1 to 7: ");
                input.next();
            }

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    display();
                    break;

                case 2:
                    System.out.print("Search for salesperson: ");
                    String name = input.nextLine();

                    int position = findSalesPerson(name);

                    if (position != -1) {
                        System.out.println(name + " is found at "
                                + position);
                    } else {
                        System.out.println("Salesperson not found.");
                    }
                    break;

                case 3:
                    System.out.println(calcTotalMonthlySales());
                    break;

                case 4:
                    System.out.println(calcMonthlySalary());
                    break;

                case 5:
                    getBestSalesPerson();
                    break;

                case 6:
                    System.out.println("Monthly Turnover "
                            + calcMonthlyTurnOver());
                    break;

                case 7:
                    System.out.println("Salary Expenditure "
                            + calcSalaryExpenditure());
                    break;

                default:
                    System.out.println("Invalid option.");
            }

            System.out.print("Do you want to continue? (Y/N) ");
            answer = input.nextLine();

        } while (answer.equalsIgnoreCase("Y"));

        System.out.println("Program ended.");
        input.close();
    }

}
