import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Arrays;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) deque.add(c);
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) return false;
        }
        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // List of strategies
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        List<String> names = Arrays.asList("StackStrategy", "DequeStrategy", "TwoPointerStrategy");

        // Run each strategy and measure time
        for (int i = 0; i < strategies.size(); i++) {
            PalindromeStrategy strategy = strategies.get(i);
            String name = names.get(i);

            long start = System.nanoTime();
            boolean result = strategy.isPalindrome(userInput);
            long end = System.nanoTime();

            long duration = end - start;
            System.out.println(name + ": " + result + " (Time: " + duration + " ns)");
        }

        scanner.close();
    }
}
