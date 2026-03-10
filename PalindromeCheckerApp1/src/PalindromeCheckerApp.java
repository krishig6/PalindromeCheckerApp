import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Stack<Character> stack = new Stack<>();

            System.out.print("Enter a string: ");
            String str = sc.nextLine();

            // Push characters into stack
            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }

            // Pop characters to create reversed string
            String reversed = "";
            while (!stack.isEmpty()) {
                reversed = reversed + stack.pop();
            }

            // Check palindrome
            if (str.equals(reversed)) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not a Palindrome");
            }

            sc.close();
        }

}