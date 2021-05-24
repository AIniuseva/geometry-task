package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Cone;
import com.epam.geometry.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectorTest {

    @Test
    public void testProcess() throws DataException {
        //given
        DataReader dataReader = mock(DataReader.class);
        ConeDataValidator coneValidator = mock(ConeDataValidator.class);
        ConeCreator coneCreator = mock(ConeCreator.class);

        Director director = new Director(dataReader, coneValidator, coneCreator);
        //when
        when(dataReader.readLines(anyString())).thenReturn(fillListForTests());

        when(coneValidator.validate("1.0 2.0 3.0 12.0 1.5")).thenReturn(true);
        when(coneValidator.validate("6.0 3.0 4.0")).thenReturn(false);
        when(coneValidator.validate("50.2 3.0 3.2 67.2 8.0")).thenReturn(true);
        when(coneValidator.validate("14.0 35.1 22.0 98.1 76.2")).thenReturn(true);
        when(coneValidator.validate("4.1 2.7 4.2 2.0")).thenReturn(false);
        when(coneValidator.validate("61.9 6.t0 3.0 12.0 3.3")).thenReturn(false);
        when(coneValidator.validate("9.2 2.1 3.1 22.0 12.7")).thenReturn(true);
        when(coneValidator.validate("4.3 2.6 5.g7 13.0 2d.8")).thenReturn(false);

        when(coneCreator.create("1.0 2.0 3.0 12.0 1.5")).thenReturn
                (new Cone(new Point(1.0, 2.0, 3.0), 12.0, 1.5));
        when(coneCreator.create("50.2 3.0 3.2 67.2 8.0")).thenReturn
                (new Cone(new Point(50.2, 3.0, 3.2), 67.2, 8.0));
        when(coneCreator.create("14.0 35.1 22.0 98.1 76.2")).thenReturn
                (new Cone(new Point(14., 35.1, 22.0), 98.1, 76.2));
        when(coneCreator.create("9.2 2.1 3.1 22.0 12.7")).thenReturn
                (new Cone(new Point(9.2, 2.1, 3.1), 22.0, 12.7));

        List<Cone> actualCones = director.process("src/test/resources/datafortest.txt");
        List<Cone> expectedCones = fillConesListForTests();
        //then
        Assert.assertEquals(expectedCones, actualCones);
    }

    private List<Cone> fillConesListForTests() {
        List<Cone> coneList = new ArrayList<>();
        coneList.add(new Cone(new Point(1.0, 2.0, 3.0), 12.0, 1.5));
        coneList.add(new Cone(new Point(50.2, 3.0, 3.2), 67.2, 8.0));
        coneList.add(new Cone(new Point(14., 35.1, 22.0), 98.1, 76.2));
        coneList.add(new Cone(new Point(9.2, 2.1, 3.1), 22.0, 12.7));
        return coneList;
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
