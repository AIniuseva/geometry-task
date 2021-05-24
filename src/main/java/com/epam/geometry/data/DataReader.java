package com.epam.geometry.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public List<String> readLines(String filename) throws DataException {

        List<String> data = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new DataException("file is invalid", e.getCause());
        }

        return data;
    }
}
