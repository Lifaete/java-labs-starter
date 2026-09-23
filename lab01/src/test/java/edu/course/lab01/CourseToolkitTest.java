package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CourseToolkitTest {
    // isEven
    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }
    // isPrime
    @Test
    void isPrimeReturnsFalseForNumbersLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(-5));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void isPrimeReturnsTrueForPrimeNumbers() {
        assertTrue(CourseToolkit.isPrime(2));
        assertTrue(CourseToolkit.isPrime(13));
    }

    @Test
    void isPrimeReturnsFalseForCompositeNumbers() {
        assertFalse(CourseToolkit.isPrime(4));
        assertFalse(CourseToolkit.isPrime(9));
        assertFalse(CourseToolkit.isPrime(15));
    }

    @Test
    void isPrimeHandlesSquareOfPrime() {
        assertFalse(CourseToolkit.isPrime(49));
    }
    // isPalindrome
    @Test
    void isPalindromeReturnsTrueForExactPalindromeAndEmptyString() {
        assertTrue(CourseToolkit.isPalindrome("level"));
        assertTrue(CourseToolkit.isPalindrome(""));
    }

    @Test
    void isPalindromeIsCaseSensitive() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
    }

    @Test
    void isPalindromeIsSpaceSensitive() {
        assertFalse(CourseToolkit.isPalindrome("lev el"));
    }

    @Test
    void isPalindromeThrowsForNull() {
        boolean thrown = false;
        try {
            CourseToolkit.isPalindrome(null);
        } catch (IllegalArgumentException expected) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    // average
    @Test
    void averageReturnsFractionalResult() {
        assertEquals(2.5, CourseToolkit.average(new int[]{1, 2, 3, 4}));
    }

    @Test
    void averageHandlesNegativeValues() {
        assertEquals(-2.0, CourseToolkit.average(new int[]{-1, -2, -3}));
    }

    @Test
    void averageThrowsForNullOrEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[0]));
    }

    @Test
    void averageDoesNotModifyInputArray() {
        int[] values = {5, 1, 4};
        int[] original = values.clone();
        CourseToolkit.average(values);
        assertArrayEquals(original, values);
    }
    // min
    @Test
    void minReturnsSmallestValue() {
        assertEquals(1, CourseToolkit.min(new int[]{5, 1, 4}));
    }

    @Test
    void minHandlesNegativeValues() {
        assertEquals(-7, CourseToolkit.min(new int[]{-3, -7, -5}));
    }

    @Test
    void minHandlesSingleElementArray() {
        assertEquals(42, CourseToolkit.min(new int[]{42}));
    }

    @Test
    void minThrowsForNullOrEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.min(null));
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.min(new int[0]));
    }
    // max
    @Test
    void maxReturnsLargestValue() {
        assertEquals(5, CourseToolkit.max(new int[]{5, 1, 4}));
    }

    @Test
    void maxHandlesNegativeValues() {
        assertEquals(-3, CourseToolkit.max(new int[]{-3, -7, -5}));
    }

    @Test
    void maxHandlesSingleElementArray() {
        assertEquals(42, CourseToolkit.max(new int[]{42}));
    }

    @Test
    void maxThrowsForNullOrEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.max(null));
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.max(new int[0]));
    }

}
