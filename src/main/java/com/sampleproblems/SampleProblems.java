package com.sampleproblems;

/**
 *
 */
public class SampleProblems {

    /**
     * Starting point
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SampleProblems();
    }

    Node head;

    /**
     * Main constructor
     */
    public SampleProblems() {
        // Count words in a string
        // countWords("this is a test");
        countWords("demo application");
        countWords("demo");
        countWords(null);
        // Reverse String
        reverseString("Welcome to java");
        // Substrings of a String
        final String test = "this is a demo string";
        System.out.println(test.substring(1, 10));
        // Reverse number
        reverseNumber(1234578);
        // Reverse linked list
        reverseSingleLinkedList();
        // ReverseLinkedList
        //
        // Creating a linked list
        final Node head = new Node(5);
        addToTheLast(head);
        addToTheLast(new Node(6));
        addToTheLast(new Node(7));
        addToTheLast(new Node(1));
        addToTheLast(new Node(2));

        printList(head);

        // Reversing LinkedList
        final Node reverseHead = reverseLinkedList(head);
        System.out.println("After reversing");
        printList(reverseHead);
        
        // Print numbers
        final Integer[] numbers = { 1, 2, 3, 4, 5 };
        String tempNum = "";
        for (int x = 0; x <= numbers.length - 1; x++) {
            if (tempNum == null || tempNum.trim().isEmpty()) {
                tempNum = numbers[x].toString();
            } else {
                tempNum = tempNum + " " + numbers[x];
            }
            System.out.println(tempNum);
        }
        // Reverse words
        System.out.println(reverseWords("My name is Gilberto"));

    }

    public void addToTheLast(final Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }
    }

    /**
     * count words in a string
     * 
     * @param input
     */
    public void countWords(final String input) {
        if (input == null || input.toString().trim().isEmpty()) {
            System.out
                    .println("An error ocurrs with input words. Check again.");
            return;
        }
        final String[] words = input.split(" ");
        System.out.println(words.length);
    }

    public void printList(final Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    private Node reverse(final Node n) {
        head = n;
        if (n.next == null) {
            return head;
        }

        Node nextNode = n.next;
        n.next = null;
        nextNode = reverse(nextNode);
        nextNode.next = n;
        return n;
    }

    public Node reverseLinkedList(final Node head) {
        Node current = head;
        Node newHead = null;
        while (current != null) {
            final Node tmp = current;
            current = current.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    /**
     * Reverse Number
     * 
     * @param number
     */
    public void reverseNumber(final int numberToReverse) {

        int number = numberToReverse;
        int reversedNumber = 0;
        int tempValue = 0;

        while (number > 0) {
            // Strip off last digit
            tempValue = number % 10;
            // Create Reversed Number
            reversedNumber = reversedNumber * 10 + tempValue;
            number = number / 10;
        }
        System.out.println(reversedNumber);
    }

    /**
     * Reverse a LinkedList
     */
    public void reverseSingleLinkedList() {
        final Node n1 = new Node(1);
        final Node n2 = new Node(2);
        final Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        head = n1;

        reverse(head);
        printList(head);
    }

    /**
     * Reverse a string
     * 
     * @param input
     */
    public void reverseString(final String input) {
        if (input == null || input.toString().trim().isEmpty()) {
            System.out
                    .println("An error ocurrs with input words. Check again.");
            return;
        }
        /*
         * final String reverseString = new StringBuilder(input).reverse()
         * .toString();
         */
        final int len = input.length();
        String reverseString = null;
        for (int i = len - 1; i >= 0; i--) {
            reverseString += input.charAt(i);
        }
        System.out.println(reverseString);
    }

    /**
     * Reverse words of a string
     * 
     * @param input
     * @return
     */
    public String reverseWords(final String input) {
        final String[] reversedName = input.split(" ");
        final int len = reversedName.length;
        String reverseString = "";
        for (int i = len - 1; i >= 0; i--) {
            reverseString += reversedName[i] + " ";
        }
        return reverseString;
    }
}
