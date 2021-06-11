package com.epam.geometry;

public class ConeDataValidator {

    private static final String CONE_PATTERN = "([1-9]\\d*.[0-9]\\s){4}[1-9]\\d*.[0-9]";

    public boolean validate(String line) {
        return line != null && line.matches(CONE_PATTERN);
    }
}
