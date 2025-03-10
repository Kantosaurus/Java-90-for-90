import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string or number to check if it's a palindrome: ");
        String input = scanner.nextLine().trim();

        if (isPalindrome(input)) {
            System.out.println("The input is a palindrome!");
        } else {
            System.out.println("The input is NOT a palindrome.");
        }

        scanner.close();
    }

    private static boolean isPalindrome(String s) {
        // Step 1: Normalize the input
        StringBuilder normalized = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // Keep only alphanumeric characters
                normalized.append(Character.toLowerCase(c)); // Convert to lowercase
            }
        }

        // Step 2: Two-pointer comparison
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false; // Characters don't match
            }
            left++;
            right--;
        }

        return true; // All characters matched
    }
}