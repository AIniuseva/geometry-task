package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private static final Logger LOGGER = LogManager.getLogger(Director.class);
    private final DataReader dataReader;
    private final ConeDataValidator coneValidator;
    private final ConeCreator coneCreator;

    public Director(DataReader reader, ConeDataValidator validator, ConeCreator creator) {
        this.dataReader = reader;
        this.coneValidator = validator;
        this.coneCreator = creator;
    }

    public List<Cone> process(String filename) {
        List<Cone> cones = new ArrayList<>();

        try {
            List<String> data = dataReader.readLines(filename);
            for (String line : data) {
                if (coneValidator.validate(line)) {
                    cones.add(coneCreator.create(line));
                }
            }

        } catch (DataException e) {
            LOGGER.error(e.getMessage());
            e.getCause();
        }

        return cones;
    }
}
