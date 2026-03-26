/**
 * ============================================================
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 3: Reverse String Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 *
 * At this stage, the application:
 * - Iterates the string in reverse order
 * - Builds a reversed version
 * - Compares original and reversed strings
 * - Displays the validation result
 *
 * This introduces transformation-based validation.
 *
 * @author Developer
 * @version 3.0
 */

package com.palindrome.app;

public class UseCase3PalindromeCheckerApp {

    /**
     * Application entry point for UC3.
     *
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {

        // Hardcoded string
        String input = "level";

        String reversed = "";

        // Reverse string using loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Display both strings
        System.out.println("Original String : " + input);
        System.out.println("Reversed String : " + reversed);

        // Compare using equals()
        if (input.equals(reversed)) {
            System.out.println("Result          : It is a Palindrome ✅");
        } else {
            System.out.println("Result          : Not a Palindrome ❌");
        }
    }
}