/**
 * ============================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a Stack-based strategy
 * - Implements a Deque-based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * The goal is to teach extensible algorithm design.
 *
 * @author Developer
 * @version 12.0
 */

package com.palindrome.app;

import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";

        // Choose strategy (change this line to switch algorithm)
        PalindromeStrategy strategy = new StackStrategy();
        // PalindromeStrategy strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        System.out.println("Input String : " + input);
        System.out.println("Strategy Used: " + strategy.getClass().getSimpleName());

        if (result) {
            System.out.println("Result       : It is a Palindrome ✅");
        } else {
            System.out.println("Result       : Not a Palindrome ❌");
        }
    }
}

/**
 * INTERFACE - PalindromeStrategy
 * Defines contract for all palindrome algorithms
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * CONTEXT CLASS
 * Uses a strategy
 */
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}

/**
 * STACK STRATEGY
 */
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * DEQUE STRATEGY
 */
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}