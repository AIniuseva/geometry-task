package com.epam.geometry;

import com.epam.geometry.model.Cone;
import org.junit.Assert;
import org.junit.Test;

public class ConeCreatorTest {

    @Test
    public void testCreator() {
        //given
        ConeCreator coneCreator = new ConeCreator();
        //when
        Cone actualCone = coneCreator.create("1.0 2.0 3.0 12.0 5.5");
        //then
        Assert.assertEquals(1, actualCone.getPoint().getX(),0);
        Assert.assertEquals(2, actualCone.getPoint().getY(),0);
        Assert.assertEquals(3, actualCone.getPoint().getZ(),0);
        Assert.assertEquals(12, actualCone.getHeight(),0);
        Assert.assertEquals(5.5, actualCone.getRadius(),0);
    }
}
