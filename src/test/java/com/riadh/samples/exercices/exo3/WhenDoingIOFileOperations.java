package com.riadh.samples.exercices.exo3;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.riadh.samples.MyCustomIOException;
import com.riadh.samples.exo3.MyFileWriter;

public class WhenDoingIOFileOperations {

    private MyFileWriter   myWriter;
    private List<String>   myList;

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    private File           myFile;

    @Before
    public void setUp() throws Exception {

        myList = new ArrayList<String>();
        populate(myList);
        myFile = testFolder.newFile("myTestFile.txt");
        myWriter = new MyFileWriter(myList, myFile);
    }

    @After
    public void tearDown() throws Exception {
        testFolder.delete();
        myList = null;
        myWriter = null;
    }

    @Test
    public void shouldWritingIntoFileOperationWorkProperly() throws Exception {
        myWriter.write();
        Assert.assertNotNull(myWriter.getFile());
        // read file to check
        @SuppressWarnings("rawtypes")
        List linesFromAlreadyWrittenFile = FileUtils.readLines(myFile);
        assertThat(linesFromAlreadyWrittenFile.size(), is(equalTo(10)));
    }

    @Test(expected = MyCustomIOException.class)
    @Ignore
    public void shouldWritingIntoFileOperationThrowExceptionWhenNullArguments() throws Exception {
        myWriter = new MyFileWriter(null, null);
        myWriter.write();
    }

    private void populate(List<String> listToPopulate) {
        for (int i = 0; i < 10; i++) {
            listToPopulate.add("Test" + i);
        }
    }
}
