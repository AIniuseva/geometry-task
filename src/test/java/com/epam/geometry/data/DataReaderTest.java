package com.epam.geometry.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest {

    @Test
    public void testReadLines() throws DataException {
        //given
        DataReader dataReader = new DataReader();
        final List<String> expectedList = fillListForTests();
        //when
        final List<String> actualList = dataReader.readLines("src/test/resources/datafortest.txt");
        //then
        Assert.assertEquals(expectedList, actualList);
    }

    private List<String> fillListForTests() {
        List<String> list = new ArrayList<>();
        list.add("1.0 2.0 3.0 12.0 1.5");
        list.add("6.0 3.0 4.0");
        list.add("50.2 3.0 3.2 67.2 8.0");
        list.add("14.0 35.1 22.0 98.1 76.2");
        list.add("4.1 2.7 4.2 2.0");
        list.add("61.9 6.t0 3.0 12.0 3.3");
        list.add("9.2 2.1 3.1 22.0 12.7");
        list.add("4.3 2.6 5.g7 13.0 2d.8");
        return list;
    }
}
