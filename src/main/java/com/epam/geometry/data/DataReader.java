package com.epam.geometry.data;

import com.epam.geometry.ConeDataValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    //TODO: implement this method using BufferedReader, do not throw original IOException, wrap it with your own
    public List<String> readLines(String filename) throws DataException {

        List<String> data = new ArrayList<>();
        ConeDataValidator validator = new ConeDataValidator();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (validator.validate(line)) {
                    data.add(line);
                }
            }

        } catch (IOException e) {
            throw new DataException("file is invalid", e.getCause());
        }

        return data;
    }
}
