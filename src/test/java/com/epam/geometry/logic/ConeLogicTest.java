package com.epam.geometry.logic;

import com.epam.geometry.model.Cone;
import com.epam.geometry.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConeLogicTest {

    private ConeLogic coneLogic;

    @Before
    public void setUp() {
        coneLogic = new ConeLogic();
    }

    @Test
    public void testVolumeCalculation() {
        //given
        Cone cone = createConeForTests();
        //when
        double actualVolume = coneLogic.calculateVolume(cone);
        double expectedVolume = (double) 1 / 3 * Math.PI * Math.pow(5, 2) * 10;
        //then
        Assert.assertEquals(actualVolume, expectedVolume, 0);
    }

    @Test
    public void testSurfaceAreaCalculation() {
        //given
        Cone cone = createConeForTests();
        //when
        double actualSurfaceArea = coneLogic.calculateSurfaceArea(cone);

        double expectedSurfaceArea = Math.PI * 5 * Math.sqrt(125) + Math.PI * Math.pow(5, 2);
        //then
        Assert.assertEquals(actualSurfaceArea, expectedSurfaceArea, 0);
    }

    private Cone createConeForTests() {
        Point center = new Point(5, 3, 0);
        return new Cone(center, 10, 5);
    }
}
