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
        //then
        Assert.assertEquals(261.79938779914943, actualVolume, 0);
    }

    @Test
    public void testSurfaceAreaCalculation() {
        //given
        Cone cone = createConeForTests();
        //when
        double actualSurfaceArea = coneLogic.calculateSurfaceArea(cone);
        //then
        Assert.assertEquals(254.160184615763, actualSurfaceArea, 0);
    }

    private Cone createConeForTests() {
        Point center = new Point(5, 3, 0);
        return new Cone(center, 10, 5);
    }
}
