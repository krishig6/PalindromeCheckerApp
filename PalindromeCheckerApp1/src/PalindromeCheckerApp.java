import java.util.Scanner;


public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        // Step 1: Normalize string
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply palindrome logic
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Check palindrome
        if (isPalindrome(userInput)) {
            System.out.println("It is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("It is NOT a palindrome.");
        }

        scanner.close();
    }
}