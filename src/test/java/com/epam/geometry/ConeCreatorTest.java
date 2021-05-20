package com.epam.geometry;

import com.epam.geometry.model.Cone;
import com.epam.geometry.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class ConeCreatorTest {

    @Test
    public void testCreator() {
        //given
        ConeCreator coneCreator = new ConeCreator();
        Point center = new Point(1, 2, 3);
        Cone expectedCone = new Cone(center, 12, 5.5);
        //when
        Cone actualCone = coneCreator.create("1.0 2.0 3.0 12.0 5.5");
        //then
        Assert.assertEquals(expectedCone, actualCone);
    }
}
