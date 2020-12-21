package org.rodion.homeworks.homework8;

public class FileSystemFile implements FileSystemNode {

    private String name;

    public FileSystemFile(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
