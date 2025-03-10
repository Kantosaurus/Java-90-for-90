import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter a number (x): ");
        int x = scanner.nextInt();

        // Loop through numbers from 1 to x
        for (int i = 1; i <= x; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // If divisible by both 3 and 5, print "FizzBuzz"
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                // If divisible by 3, print "Fizz"
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                // If divisible by 5, print "Buzz"
                System.out.println("Buzz");
            } else {
                // Otherwise, print the number itself
                System.out.println(i);
            }
        }

        scanner.close();
    }
}