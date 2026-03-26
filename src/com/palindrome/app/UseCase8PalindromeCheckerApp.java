/**
 * ============================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a Singly Linked List.
 *
 * Characters are added into a linked list.
 * Then:
 * - Middle is found using fast and slow pointers
 * - Second half is reversed in-place
 * - Both halves are compared
 *
 * This demonstrates efficient in-place palindrome validation.
 *
 * @author Developer
 * @version 8.0
 */

package com.palindrome.app;

public class UseCase8PalindromeCheckerApp {

    // Node class
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Application entry point for UC8.
     *
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {

        String input = "madam";

        // Step 1: Convert string to linked list
        Node head = null, tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Find middle using fast & slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node prev = null;
        Node curr = slow;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 4: Compare halves
        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Display result
        System.out.println("Input String : " + input);

        if (isPalindrome) {
            System.out.println("Result       : It is a Palindrome ✅");
        } else {
            System.out.println("Result       : Not a Palindrome ❌");
        }
    }
}