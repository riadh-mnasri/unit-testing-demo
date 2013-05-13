package com.riadh.samples;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author Riadh MNASRI
 * 
 */
public class WhenUsingFiles {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void shouldLoadFromPropertiesFile() throws IOException {
        File tempFile = testFolder.newFile("file.txt");
        File tempFolder = testFolder.newFolder("folder");
        System.out.println("Test folder: " + testFolder.getRoot());
        // test...
    }

}
