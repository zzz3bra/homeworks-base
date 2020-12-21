package org.rodion.homeworks.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class FileSystemFolder implements FileSystemNode {

    private String name;
    private List<FileSystemFolder> folders = new ArrayList<>();
    private List<FileSystemFile> files = new ArrayList<>();

    public FileSystemFolder(String name) {
        this.name = name;
    }

    public List<FileSystemFolder> getFolders() {
        return Collections.unmodifiableList(folders);
    }

    public List<FileSystemFile> getFiles() {
        return Collections.unmodifiableList(files);
    }

    @Override
    public String getName() {
        return name;
    }

    public void addFolder(FileSystemFolder newFolder) {
        folders.add(newFolder);
    }

    public void addFile(FileSystemFile file) {
        files.add(file);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FileSystemFolder.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("folders=" + folders)
                .add("files=" + files)
                .toString();
    }
}
