package org.rodion.homeworks.homework8;

public class AlphabeticalFoldersFirstPrinter {
    private final FileSystemFolder rootFolder;

    public AlphabeticalFoldersFirstPrinter(FileSystemFolder rootFolder) {
        this.rootFolder = rootFolder;
    }

    public String print() {
        return printRecursive(rootFolder, "", 0);
    }

    private String printRecursive(FileSystemFolder currentFolder, String parentPath, int level) {
        String result = parentPath + "\n";
        result += currentFolder.getName() + "/";
        for (FileSystemFolder folder : currentFolder.getFolders()) {
            result += printRecursive(folder, parentPath, level + 1);
        }
        return result;
    }
}
