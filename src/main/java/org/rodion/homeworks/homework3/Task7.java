package org.rodion.homeworks.homework3; //Пакет назван по имени + номеру домашней работы и/или номеру задания работы

import java.util.Arrays;
import java.util.Random;

public class Task7 { //Класс назван по номеру задания домашней работы и/или имеет уникальное имя описывающее назначение

    public static void main(String[] args) {
        int[] arrayWithRandomValues = new int[12];
        Random random = new Random();

        for (int i = 0;
             i < arrayWithRandomValues.length;
             i++) {
            arrayWithRandomValues[i] = random.nextInt(16);
        }

        int lastIndexOfMaxElement = getLastIndexOfMaxElement(arrayWithRandomValues);
        int maxValue = arrayWithRandomValues[lastIndexOfMaxElement];

        System.out.println("Last occurrence of max element " + maxValue + " in array "
                + Arrays.toString(arrayWithRandomValues) + " has index " + lastIndexOfMaxElement);
    }

    public static int getLastIndexOfMaxElement(int[] array) {
        int biggestIndexOfMaxElement = array.length - 1; // last index in array
        for (int i = array.length - 1;
             i > 0;
             i--) {
            if (array[i] > array[biggestIndexOfMaxElement]) {
                biggestIndexOfMaxElement = i;
            }
        }
        return biggestIndexOfMaxElement;
    }
}
