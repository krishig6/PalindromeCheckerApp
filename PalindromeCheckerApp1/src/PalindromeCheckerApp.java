import java.util.Scanner;
class PalindromeChecker {
    // Encapsulated method to check palindrome
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Normalize: remove spaces and lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Palindrome check using two-pointer technique
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
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Use the encapsulated service
        if (checker.checkPalindrome(userInput)) {
            System.out.println("It is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("It is NOT a palindrome.");
        }

        scanner.close();
    }

}