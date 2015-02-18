package com.sampleproblems;

/**
 *
 */
public class SampleProblems {

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
        /*final String reverseString = new StringBuilder(input).reverse()
                .toString();
       */
        final int len = input.length();
        String reverseString = null;
        for (int i= len -1; i >=0; i--) {
            reverseString += input.charAt(i);
        }
        System.out.println(reverseString);
    }

    /**
     * Main constructor
     */
    public SampleProblems() {
        // Count words in a string
        countWords("this is a test");
        countWords("demo application");
        countWords("demo");
        countWords(null);
        // Reverse String
        reverseString("Welcome to java");
    }

    /**
     * Starting point
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SampleProblems();
    }
}
