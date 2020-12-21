package org.rodion.homeworks.homework8;

import java.util.Scanner;

public class FileSystemCreatorRunner {

    public static void main(String[] args) {
        FileSystemCreator fileSystemCreator = new FileSystemCreator();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                break;
            } else if ("print".equals(line)) {
                FileSystemFolder rootFolder = fileSystemCreator.getRootFolder();
                AlphabeticalFoldersFirstPrinter printer = new AlphabeticalFoldersFirstPrinter(rootFolder);
                System.out.println(printer.print());
            } else {
                FileSystemFolder result = fileSystemCreator.process(line);
                System.out.println(result);
            }
        }
    }

}
