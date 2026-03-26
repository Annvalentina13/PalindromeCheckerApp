/**
 * ============================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside a
 * PalindromeService class.
 *
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * @author Developer
 * @version 11.0
 */

package com.palindrome.app;

public class UseCase11PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        String input = "madam";

        // Create service object
        PalindromeService service = new PalindromeService();

        boolean result = service.checkPalindrome(input);

        System.out.println("Input String : " + input);

        if (result) {
            System.out.println("Result       : It is a Palindrome ✅");
        } else {
            System.out.println("Result       : Not a Palindrome ❌");
        }
    }
}

/**
 * Service class that contains palindrome logic
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}