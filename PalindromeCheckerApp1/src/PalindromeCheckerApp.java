import java.util.Stack;
import java.util.Scanner;
import java.util.*;
public class PalindromeCheckerApp {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : word.toCharArray()){
            deque.addLast(c);
        }

        boolean palindrome = true;

        while(deque.size() > 1){
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if(first != last){
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