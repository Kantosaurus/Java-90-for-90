import java.util.*;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! What is your name? ");
        String name = scanner.nextLine();
        System.out.println(name + ", welcome to the BMI Calculator!");
        double height = height(scanner);
        double weight = weight(scanner);
        bmi(height, weight);
        scanner.close();
    }

    private static void bmi(double height, double weight){
        double bmi = weight / (height * height);
        System.out.println("Your BMI is " + bmi);
        if (bmi < 18.5){
            System.out.println("You are really thin!");
        } else if (bmi < 24.9){
            System.out.println("You are healthy!");
        } else if (bmi < 30){
            System.out.println("You are overweight!");
        } else {
            System.out.println("You are obese!");
        }
    }


    private static double height(Scanner scanner) {
        while (true) {
            System.out.println("What is your height in meters (m)? ");
            if (scanner.hasNextDouble()) {
                double userHeight = scanner.nextDouble();
                if (userHeight > 3) {
                    System.out.println("No human is more than 3m tall!");
                    System.out.println("Please input your height again!");
                } else if (userHeight < 0) {
                    System.out.println("You can't have negative height!");
                    System.out.println("Please input your height again!");
                } else {
                    return userHeight;
                }
            } else {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static double weight(Scanner scanner){
        while (true) {
            System.out.println("What is your weight in kilograms (kg)? ");
            if (scanner.hasNextDouble()) {
                double userWeight = scanner.nextDouble();
                if (userWeight > 200) {
                    System.out.println("No human is more than 200kg!");
                    System.out.println("Please input your weight again!");
                } else if (userWeight < 0) {
                    System.out.println("You can't have negative weight!");
                    System.out.println("Please input your weight again!");
                } else {
                    return userWeight;
                }
            } else {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }
    }

}
