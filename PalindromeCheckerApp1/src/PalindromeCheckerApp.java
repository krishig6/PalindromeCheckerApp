import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Step 2: Implement Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push all characters onto stack
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        // Compare by popping
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Step 3: Implement Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to deque
        for (char c : normalized.toCharArray()) {
            deque.add(c);
        }

        // Compare from both ends
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}

// Step 4: Context class that uses a strategy
class PalindromeService {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Choose strategy dynamically
        PalindromeService stackService = new PalindromeService(new StackStrategy());
        PalindromeService dequeService = new PalindromeService(new DequeStrategy());

        System.out.println("Using StackStrategy: " + stackService.check(userInput));
        System.out.println("Using DequeStrategy: " + dequeService.check(userInput));

        scanner.close();
    }
}
