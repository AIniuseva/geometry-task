package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Cone;

import java.util.ArrayList;
import java.util.List;

public class Director {

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
                    Cone cone = coneCreator.create(line);
                    cones.add(cone);
                }
            }
        } catch (DataException e) {
            e.getCause();
        }

        return cones;
    }
}
