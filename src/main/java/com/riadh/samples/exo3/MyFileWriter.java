package com.riadh.samples.exo3;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.riadh.samples.MyCustomIOException;

/**
 * 
 * @author Riadh MNASRI
 *
 */
public class MyFileWriter {

    private List<String> inputData;
    private File         file;

    public MyFileWriter(List<String> inputData, File file) {
        super();
        this.inputData = inputData;
        this.file = file;
    }

    public List<String> getInputData() {
        return inputData;
    }

    public void setInputData(List<String> inputData) {
        this.inputData = inputData;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void write() throws MyCustomIOException {
        if (file == null) {
            throw new MyCustomIOException("The file where to write should not be null");
        }
        if (inputData == null) {
            throw new MyCustomIOException("The input data should not be null");
        }

        StringBuilder builder = new StringBuilder();
        try {
            for (String str : inputData) {
                builder.append(str);
                builder.append("\n");
                System.out.println(str);
            }
            FileUtils.writeStringToFile(file, builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
