package com.epam.geometry;

// TODO: make this name more specific (according to your task)
public class ConeDataValidator {

    // Do validation using regexp
    // this method should not be long, just 1-2 lines
    // keep your line pattern as constant in this class

    private static final String CONE_PATTERN = "([1-9]\\d*.[0-9]\\s){4}[1-9]\\d*.[0-9]";

    public boolean validate(String line) {
        return line != null && line.matches(CONE_PATTERN);
    }
}
