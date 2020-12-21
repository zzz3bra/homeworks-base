package org.rodion.homeworks.homework8;

public class FileSystemCreator {

    private FileSystemFolder rootFolder = new FileSystemFolder("");

    public FileSystemFolder process(String command) {
        String[] paths = command.split("/");

        FileSystemFolder currentFolder = rootFolder;
        for (String path : paths) {
            if (isFile(path)) {
                currentFolder.addFile(new FileSystemFile(path));
                break;
            }

            FileSystemFolder existingFolder = null;
            for (FileSystemFolder folder : currentFolder.getFolders()) {
                if (folder.getName().equals(path)) {
                    existingFolder = folder;
                    break;
                }
            }

            if (existingFolder == null) {
                FileSystemFolder newFolder = new FileSystemFolder(path);
                currentFolder.addFolder(newFolder);
                currentFolder = newFolder;
            } else {
                currentFolder = existingFolder;
            }
        }
        return rootFolder;
    }

    private boolean isFile(String path) {
        //TODO: refactor to separate class - FileNameValidator
        return path.contains(".");
    }

    public FileSystemFolder getRootFolder() {
        return rootFolder;
    }
}
