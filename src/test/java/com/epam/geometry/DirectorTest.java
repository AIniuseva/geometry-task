package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Cone;
import com.epam.geometry.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectorTest {

    private static final String SAMPLE_PATH = "src/test/resources/datafortest.txt";
    private static final List<Cone> EXPECTED_CONES = Arrays.asList
            (new Cone(new Point(1.0, 2.0, 3.0), 12.0, 1.5),
                    new Cone(new Point(50.2, 3.0, 3.2), 67.2, 8.0),
                    new Cone(new Point(14., 35.1, 22.0), 98.1, 76.2),
                    new Cone(new Point(9.2, 2.1, 3.1), 22.0, 12.7));
    private static final List<String> INPUT_DATA = Arrays.asList
            ("1.0 2.0 3.0 12.0 1.5",
                    "6.0 3.0 4.0",
                    "50.2 3.0 3.2 67.2 8.0",
                    "14.0 35.1 22.0 98.1 76.2",
                    "4.1 2.7 4.2 2.0",
                    "61.9 6.t0 3.0 12.0 3.3",
                    "9.2 2.1 3.1 22.0 12.7",
                    "4.3 2.6 5.g7 13.0 2d.8");

    @Test
    public void testProcess() throws DataException {
        //given
        DataReader dataReader = mock(DataReader.class);
        ConeDataValidator coneValidator = mock(ConeDataValidator.class);
        ConeCreator coneCreator = mock(ConeCreator.class);

        Director director = new Director(dataReader, coneValidator, coneCreator);
        //when
        when(dataReader.readLines(anyString())).thenReturn(INPUT_DATA);

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

        List<Cone> actualCones = director.process(SAMPLE_PATH);
        //then
        Assert.assertEquals(EXPECTED_CONES, actualCones);
    }
}
