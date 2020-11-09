package org.rodion.homeworks.homework3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {

    @Test
    public void testGetLastIndexOfMaxElementForEmptyArrayShouldReturnMinusOne() { // negative
        int[] array = new int[0]; //empty array - has size 0

        int actualIndex = Task7.getLastIndexOfMaxElement(array);

        assertEquals(-1, actualIndex);
    }

    @Test
    public void testGetLastIndexOfMaxElementWithDuplicates() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 2, 4, 5, 7, 4, 3, 6, 8, 42, 0, 42, 0};
        final int indexOfLast42 = array.length - 1 - 1;

        int actualIndex = Task7.getLastIndexOfMaxElement(array);

        assertEquals(indexOfLast42, actualIndex);
    }

    @Test
    public void testGetLastIndexOfMaxElementWithDuplicatesLessThanZero() {
        int[] array = new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -2, -4, -5, -7, -4, -3, -6, -8, -42, 0, -42, 0};
        final int indexOfLast0 = array.length - 1;

        int actualIndex = Task7.getLastIndexOfMaxElement(array);

        assertEquals(indexOfLast0, actualIndex);
    }

    @Test
    public void testGetLastIndexOfMaxElementSimple() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        final int indexOfMaxElement = array.length - 1;

        int actualIndex = Task7.getLastIndexOfMaxElement(array);

        assertEquals(indexOfMaxElement, actualIndex);
    }
}
