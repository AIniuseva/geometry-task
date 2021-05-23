package com.epam.geometry.data;

import com.epam.geometry.ConeCreator;
import com.epam.geometry.ConeDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger logger = LogManager.getLogger(DataReader.class);

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
            logger.error(e.getMessage());
            throw new DataException("file is invalid", e.getCause());
        }

        return data;
    }
}
