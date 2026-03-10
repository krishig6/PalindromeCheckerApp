import java.util.Stack;
import java.util.Scanner;
import java.util.*;
public class PalindromeCheckerApp {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a word: ");
            String word = sc.nextLine();

            Queue<Character> queue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            for(char c : word.toCharArray()){
                queue.add(c);   // Enqueue
                stack.push(c);  // Push
            }

            boolean palindrome = true;

            while(!queue.isEmpty()){
                if(queue.remove() != stack.pop()){
                    palindrome = false;
                    break;
                }
            }

            if(palindrome)
                System.out.println("Palindrome");
            else
                System.out.println("Not a Palindrome");
        }

}