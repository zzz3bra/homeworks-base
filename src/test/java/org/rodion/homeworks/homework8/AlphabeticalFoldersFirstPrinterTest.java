package org.rodion.homeworks.homework8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlphabeticalFoldersFirstPrinterTest {

    @Test
    void printRootOnly() {
        AlphabeticalFoldersFirstPrinter printer = new AlphabeticalFoldersFirstPrinter(new FileSystemFolder(""));

        String result = printer.print();

        Assertions.assertEquals("/", result);
    }

    @Test
    void printTwoLevelHierarchy() {
        FileSystemFolder rootFolder = new FileSystemFolder("");
        rootFolder.addFolder(new FileSystemFolder("second"));
        rootFolder.addFolder(new FileSystemFolder("first"));

        AlphabeticalFoldersFirstPrinter printer = new AlphabeticalFoldersFirstPrinter(rootFolder);

        String result = printer.print();

        Assertions.assertEquals("\n" +
                "/\n" +
                "second/\n" +
                "first/", result);
    }
}