import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! This is a temperature unit converter!");

        // Input unit selection
        String input = "";
        boolean in = true;
        int attempts = 0;
        while (in) {
            System.out.println("Please choose what your input units are (C / K / F): ");
            input = scanner.nextLine().toLowerCase();
            in = !(input.equals("c") || input.equals("k") || input.equals("f"));
            if (in) {
                System.out.println("Invalid input! Please try again.");
                attempts++;
                if (attempts >= 3) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    scanner.close();
                    return;
                }
            }
        }

        // Output unit selection
        String output = "";
        boolean out = true;
        attempts = 0;
        while (out) {
            System.out.println("Please choose what your output units are (C / K / F): ");
            output = scanner.nextLine().toLowerCase();
            out = !(output.equals("c") || output.equals("k") || output.equals("f"));
            if (out) {
                System.out.println("Invalid input! Please try again.");
                attempts++;
                if (attempts >= 3) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    scanner.close();
                    return;
                }
            }
        }

        // Perform the conversion
        converter(input, output);

        scanner.close();
    }

    public static void converter(String inputUnit, String outputUnit) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the temperature to convert: ");
        double temperature = scanner.nextDouble();

        double convertedTemperature = 0;
        switch (inputUnit) {
            case "c":
                if (outputUnit.equals("k")) {
                    convertedTemperature = temperature + 273.15;
                } else if (outputUnit.equals("f")) {
                    convertedTemperature = (temperature * 9 / 5) + 32;
                }
                break;
            case "k":
                if (outputUnit.equals("c")) {
                    convertedTemperature = temperature - 273.15;
                } else if (outputUnit.equals("f")) {
                    convertedTemperature = ((temperature - 273.15) * 9 / 5) + 32;
                }
                break;
            case "f":
                if (outputUnit.equals("c")) {
                    convertedTemperature = (temperature - 32) * 5 / 9;
                } else if (outputUnit.equals("k")) {
                    convertedTemperature = ((temperature - 32) * 5 / 9) + 273.15;
                }
                break;
        }
        System.out.println("Converted temperature: " + convertedTemperature + " " + outputUnit.toUpperCase());
        scanner.close();
    }
}