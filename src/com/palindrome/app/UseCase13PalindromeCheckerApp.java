/**
 * ============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses multiple palindrome strategy implementations
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */

package com.palindrome.app;

import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama"
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        // Strategies
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        // Benchmark Stack Strategy
        long start1 = System.nanoTime();
        boolean result1 = stackStrategy.check(input);
        long end1 = System.nanoTime();

        // Benchmark Deque Strategy
        long start2 = System.nanoTime();
        boolean result2 = dequeStrategy.check(input);
        long end2 = System.nanoTime();

        // Display Results
        System.out.println("Input String : " + input);
        System.out.println("--------------------------------------");

        System.out.println("Stack Strategy Result : " + result1);
        System.out.println("Time Taken (ns)       : " + (end1 - start1));

        System.out.println("--------------------------------------");

        System.out.println("Deque Strategy Result : " + result2);
        System.out.println("Time Taken (ns)       : " + (end2 - start2));
    }
}

/**
 * STRATEGY INTERFACE
 */
interface PalindromeStrategy {
    boolean check(String input);
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