package org.rodion.homeworks.homework8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileSystemCreatorTest {

    FileSystemCreator creator;

    @BeforeEach
    void setUp() {
        creator = new FileSystemCreator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testOneFolderAddition() {
        //prepare our data and classes
        creator.process("usr/bin");

        //perform action
        FileSystemFolder result = creator.getRootFolder();

        //assert result
        List<FileSystemFolder> rootFolders = result.getFolders();
        Assertions.assertEquals(1, rootFolders.size());
        FileSystemFolder usrFolder = rootFolders.get(0);
        Assertions.assertEquals("usr", usrFolder.getName());
        Assertions.assertEquals(1, usrFolder.getFolders().size());
        Assertions.assertEquals("bin", usrFolder.getFolders().get(0).getName());
    }

    @Test
    void testOneFolderAdditionMultipleTimes() {
        //prepare our data and classes
        creator.process("usr/bin");
        creator.process("usr/bin");
        creator.process("usr/bin");

        //perform action
        FileSystemFolder result = creator.getRootFolder();

        //assert result
        List<FileSystemFolder> rootFolders = result.getFolders();
        Assertions.assertEquals(1, rootFolders.size());
        FileSystemFolder usrFolder = rootFolders.get(0);
        Assertions.assertEquals("usr", usrFolder.getName());
        Assertions.assertEquals(1, usrFolder.getFolders().size());
        Assertions.assertEquals("bin", usrFolder.getFolders().get(0).getName());
    }

    @Test
    void testTwoFolderAddition() {
        //prepare our data and classes
        creator.process("usr/bin");
        creator.process("usr/data");

        //perform action
        FileSystemFolder result = creator.getRootFolder();

        //assert result
        List<FileSystemFolder> rootFolders = result.getFolders();
        Assertions.assertEquals(1, rootFolders.size());
        FileSystemFolder usrFolder = rootFolders.get(0);
        Assertions.assertEquals("usr", usrFolder.getName());
        Assertions.assertEquals(2, usrFolder.getFolders().size());
        Assertions.assertEquals("bin", usrFolder.getFolders().get(0).getName());
        Assertions.assertEquals("data", usrFolder.getFolders().get(1).getName());
    }

    @Test
    void testTwoFolderAndTwoFilesAddition() {
        //prepare our data and classes
        creator.process("usr/bin/todo.txt");
        creator.process("system/data/file.txt");

        //perform action
        FileSystemFolder result = creator.getRootFolder();

        //assert result
        List<FileSystemFolder> rootFolders = result.getFolders();
        Assertions.assertEquals(2, rootFolders.size());

        FileSystemFolder usrFolder = rootFolders.get(0);
        Assertions.assertEquals("usr", usrFolder.getName());
        Assertions.assertEquals(1, usrFolder.getFolders().size());
        Assertions.assertTrue(usrFolder.getFiles().isEmpty());

        FileSystemFolder usrBinFolder = usrFolder.getFolders().get(0);
        Assertions.assertEquals("bin", usrBinFolder.getName());
        Assertions.assertTrue(usrBinFolder.getFolders().isEmpty());
        Assertions.assertEquals(1, usrBinFolder.getFiles().size());
        Assertions.assertEquals("todo.txt", usrBinFolder.getFiles().get(0).getName());

        FileSystemFolder systemFolder = rootFolders.get(1);
        Assertions.assertEquals("system", systemFolder.getName());
        Assertions.assertEquals(1, systemFolder.getFolders().size());
        Assertions.assertTrue(systemFolder.getFiles().isEmpty());

        FileSystemFolder systemDataFolder = systemFolder.getFolders().get(0);
        Assertions.assertEquals("data", systemDataFolder.getName());
        Assertions.assertTrue(systemDataFolder.getFolders().isEmpty());
        Assertions.assertEquals(1, systemDataFolder.getFiles().size());
        Assertions.assertEquals("file.txt", systemDataFolder.getFiles().get(0).getName());
    }
}
