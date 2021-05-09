package com.epam.geometry;

import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.AClass;

import java.util.List;

public class Director {

    //TODO: uncomment
//    private final DataReader reader;
//    private final Validator validator;
//    private final Creator creator;


    public Director(DataReader reader, Validator validator, Creator creator) {
        //TODO: inject you dependencies here
    }

    // Input file contains multiple lines, each line a geometry object
    // i.e. each line contains all necessary data to create object in a simple format like: 1.0 2.0 3.0
    // some line
    public List<AClass> process(String filename){
        // Read lines from file
        // for each valid line create a geometry object (according to your task)
        throw new UnsupportedOperationException();
    }
}
