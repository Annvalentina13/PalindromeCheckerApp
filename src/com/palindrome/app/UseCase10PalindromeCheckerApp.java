/**
 * ============================================================
 * MAIN CLASS - UseCase10PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 10: Normalized Palindrome Validation
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string.
 *
 * Normalization includes:
 * - Removing spaces and symbols
 * - Converting to lowercase
 *
 * This ensures the palindrome check is logical rather
 * than character-format dependent.
 *
 * Example:
 * "A man a plan a canal Panama"
 *
 * @author Developer
 * @version 10.0
 */

package com.palindrome.app;

public class UseCase10PalindromeCheckerApp {

    /**
     * Application entry point for UC10.
     *
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {

        // Input string
        String input = "A man a plan a canal Panama";

        // Step 1: Normalize string
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Check palindrome using two-pointer
        boolean isPalindrome = true;

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Display results
        System.out.println("Original String   : " + input);
        System.out.println("Normalized String : " + normalized);

        if (isPalindrome) {
            System.out.println("Result            : It is a Palindrome ✅");
        } else {
            System.out.println("Result            : Not a Palindrome ❌");
        }
    }
}